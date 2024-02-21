package DeviceCapability;

import BasesClasses.TestBase;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DeviceCaps extends TestBase {

    public static void SamsungA32() {
        caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("deviceName", "Samsung SM-A325F");
        caps.setCapability("udid", "RZ8T30532KZ");
//        caps.setCapability("app", System.getProperty("user.dir") + "/src/test/java/resource/ApiDemos-debug.apk");
        caps.setCapability("platformVersion", "13.0");
        caps.setCapability("appPackage", "io.appium.android.apis");
        caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
        caps.setCapability("noReset", false);
    }
    public static void SamsungA12() {
        caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("deviceName", "Samsung SM-A325F");
        caps.setCapability("udid", "RZ8T30532KZ");
//        caps.setCapability("app", System.getProperty("user.dir") + "/src/test/java/resource/ApiDemos-debug.apk");
        caps.setCapability("platformVersion", "13.0");
        caps.setCapability("appPackage", "io.appium.android.apis");
        caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
        caps.setCapability("noReset", false);
    }
}
