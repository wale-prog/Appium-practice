package BasesClasses;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestBase {
    DesiredCapabilities caps = new DesiredCapabilities();
    AndroidDriver driver;
    @BeforeClass
    public void mainSetup() {
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("deviceName", "Samsung SM-A325F");
        caps.setCapability("udid", "RZ8T30532KZ");
        caps.setCapability("app", System.getProperty("user.dir") + "/src/test/java/resource/ApiDemos-debug.apk");
        caps.setCapability("platformVersion", "13.0");

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        if(null != driver) {
            driver.quit();
        }
    }
}
