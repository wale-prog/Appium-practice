package BasesClasses;

import DeviceCapability.DeviceCaps;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public static DesiredCapabilities caps;
    public static AndroidDriver driver;
    private static Logger log = LogManager.getLogger(TestBase.class);
    String testData_filePath = "src/test/java/TestData.properties";
    Properties testData;
    FileInputStream fis;

    public TestBase() {
        testData = new Properties();
        try {
            fis = new FileInputStream(testData_filePath);
            testData.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setup() {
        String server = testData.getProperty("server1");
        switch (server) {
            case "local":
                log.info("The test is running on the local appium server");
                try {
                    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                    log.info("The driver has been created");

                } catch (MalformedURLException e) {
                    log.error("An error occurred creating the driver");
                }
                break;
            case "remote":
                log.info("The test is running on the remote appium server");
                try {
                    driver = new AndroidDriver(new URL("remote server address"), caps);
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                    log.info("The driver has been created");
                } catch (MalformedURLException e) {
                    log.error("An error occurred creating the driver");
                }
                break;
            default:
                throw new IllegalArgumentException("The server is not configured");
        }

    }

    @BeforeClass
    public void mainSetup() {
        String Device = testData.getProperty("device1");

        try {
            switch (Device) {
                case "SamsungA32":
                    log.info("The test is running on SamsungA32");
                    DeviceCaps.SamsungA32();
                    break;
                case "SamsungA12":
                    log.info("The test is running on SamsungA12");
                    DeviceCaps.SamsungA12();
                    break;
                default:
                    throw new IllegalArgumentException("The device capability select has not been configured");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            setup();
        }
    }

    public void scrollToEnd(String direction) {
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", direction,
                    "percent", 3.0,
                    "speed", 1750
            ));
        } while (canScrollMore);

    }

    public void scrollToText(String text) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
    }

    public void validateAttribute(WebElement el, String attribute, boolean value) {
        el.getAttribute(attribute);
        Assert.assertTrue(Boolean.parseBoolean(el.getAttribute(attribute)) == value);
    }
    public void flingGesture(WebElement el, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: flingGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) el).getId(),
                "direction", direction,
                "speed", 2000,
                "percent", 3
        ));
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        log.info("Test is ending");
        if (null != driver) {
            driver.quit();
        }
    }
}
