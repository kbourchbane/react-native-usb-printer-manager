
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNUsbPrinterManagerSpec.h"

@interface UsbPrinterManager : NSObject <NativeUsbPrinterManagerSpec>
#else
#import <React/RCTBridgeModule.h>

@interface UsbPrinterManager : NSObject <RCTBridgeModule>
#endif

@end
