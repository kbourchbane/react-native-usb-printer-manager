package com.usbprintermanager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Promise;
import android.hardware.usb.UsbManager;
import java.util.HashMap;
import java.util.Map;

import java.lang.String;

import java.lang.Number;

import java.lang.Boolean;

import org.json.JSONArray;

import org.json.JSONException;
import java.util.Map;

import java.lang.String;

import java.lang.Number;

import java.lang.Boolean;

import org.json.JSONObject;

import org.json.JSONException;
import org.json.JSONArray;

import org.json.JSONObject;

import org.json.JSONException;

public class ReactNativeUsbModule extends ReactContextBaseJavaModule {
  public ReactNativeUsbModule(ReactApplicationContext reactContext) {
    super(reactContext);
    //this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "UsbPrinterManager";
  }

  @ReactMethod
  public void multiply(Double a, Double b, Promise promise) {
    promise.resolve(a * b);
  }

  @ReactMethod
  public void getDevicesList(Promise promise) {

  }
}

/*class UsbPrinterManagerModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  init {
    // Here we're saving the context we passed into the constructor to a variable so we can emit events
    // https://facebook.github.io/react-native/docs/native-modules-android.html#the-toast-module
    reactContext = context
  }

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
    val manager: UsbManager = reactContext.getSystemService(Context.USB_SERVICE) as UsbManager
    val deviceList: HashMap<String, UsbDevice> = manager.getDeviceList()

    val gson = Gson()
    val response: String = gson.toJson(deviceList)
    val returnMap: WritableMap = this.util.convertJsonToMap(JSONObject(response))

    promise.resolve(returnMap)
  }

  companion object {
    const val NAME = "UsbPrinterManager"
  }

}*/
