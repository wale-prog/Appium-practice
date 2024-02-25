package Tests;

import BasesClasses.TestBase;
import Pages.ApiDemoPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static utils.extentReports.ExtentTestManager.startTest;
import java.lang.reflect.Method;

public class AppTest extends TestBase {

    private static Logger log = LogManager.getLogger(AppTest.class);

    @Test(priority = 1, description = "Validate that accessibility link is ")
    public void validateAppLaunch(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "appDemo");
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Reports/appTest.html");
        extent.attachReporter(spark);
        extent.createTest("Validate that the accessibility link is visible", "").assignCategory("");
        spark.config().setTheme(Theme.DARK);
        log.info("Inside AppTest");
        ApiDemoPage apiDemoPage = new ApiDemoPage(driver);
        validateAttribute(apiDemoPage.getAccessibilityLink(), "displayed", false);

        apiDemoPage.clickViewLink();
//        scrollToEnd("down");
//        scrollToText("Tabs");
        flingGesture(apiDemoPage.getGalleryElement(), "down");
        flingGesture(apiDemoPage.getGalleryElement(), "down");
        extent.flush();
        sleep(20);
    }
}
