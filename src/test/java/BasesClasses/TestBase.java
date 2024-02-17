package BasesClasses;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestBase {
    DesiredCapabilities caps = new DesiredCapabilities();
    public AndroidDriver driver;
    private static Logger log = LogManager.getLogger(TestBase.class);
    @BeforeClass
    public void mainSetup() {
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("deviceName", "Samsung SM-A325F");
        caps.setCapability("udid", "RZ8T30532KZ");
//        caps.setCapability("app", System.getProperty("user.dir") + "/src/test/java/resource/ApiDemos-debug.apk");
        caps.setCapability("platformVersion", "13.0");
        caps.setCapability("appPackage", "io.appium.android.apis");
        caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
//        caps.setCapability("noReset", false);

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.2:4724/wd/hub"), caps);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            log.info("The driver has been created");
            log.info("Test is starting");
        }catch (MalformedURLException | SessionNotCreatedException e) {
            log.error("An error occurred creating the driver");
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
        log.info("Test is ending");
        if(null != driver) {
            driver.quit();
        }
    }
}
