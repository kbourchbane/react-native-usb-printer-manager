package com.usbprintermanager

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise
import android.hardware.usb.UsbManager
import java.util.HashMap

class UsbPrinterManagerModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  override fun getName(): String {
    return NAME
  }

  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  @ReactMethod
  fun multiply(a: Double, b: Double, promise: Promise) {
    promise.resolve(a * b)
  }

  @ReactMethod
  fun getDevicesList(promise: Promise) {

    // create buttons in a loop
    val manager: UsbManager = getSystemService(Context.USB_SERVICE) as UsbManager
    val deviceList: HashMap<String, UsbDevice> = manager.getDeviceList()

    val gson = Gson()
    val response: String = gson.toJson(deviceList)
    val returnMap: WritableMap = this.util.convertJsonToMap(JSONObject(response))

    promise.resolve(returnMap)
  }

  companion object {
    const val NAME = "UsbPrinterManager"
  }

  @kotlin.Throws(JSONException::class)
  fun convertJsonToMap(jsonObject: JSONObject): WritableMap? {
    val map: WritableMap = WritableNativeMap()
    val iterator: Iterator<String> = jsonObject.keys()
    while (iterator.hasNext()) {
      val key = iterator.next()
      val value: Object = jsonObject.get(key)
      if (value is JSONObject) {
        map.putMap(key, convertJsonToMap(value as JSONObject))
      } else if (value is JSONArray) {
        map.putArray(key, convertJsonToArray(value as JSONArray))
        if ("option_values".equals(key)) {
          map.putArray("options", convertJsonToArray(value as JSONArray))
        }
      } else if (value is Boolean) {
        map.putBoolean(key, value as Boolean)
      } else if (value is Integer) {
        map.putInt(key, value as Integer)
      } else if (value is Double) {
        map.putDouble(key, value as Double)
      } else if (value is String) {
        map.putString(key, value as String)
      } else {
        map.putString(key, value.toString())
      }
    }
    return map
  }

}
