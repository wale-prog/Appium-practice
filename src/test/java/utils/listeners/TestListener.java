package utils.listeners;

import BasesClasses.TestBase;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.extentReports.ExtentManager;
import utils.logs.Log;
import static utils.extentReports.ExtentManager.extentReports;

import java.util.Objects;

import static utils.extentReports.ExtentTestManager.getTest;

public class TestListener extends TestBase implements ITestListener{

    private Logger Log = LogManager.getLogger(this);

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
    //iTestContext
    //iTestResult
    @Override
    public void onStart(ITestContext iTestContext) {
        Log.info("Test is starting " + iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        Log.info("Process is OnFinish method" + iTestContext.getName());
        ExtentManager.extentReports.flush();
    }
    @Override
    public void onTestStart(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " test is starting...");
    }
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " test has failed...");
        String failedScreenShot = "data:image/png;base64, " + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
        getTest().log(Status.FAIL, "Test has failed", getTest().addScreenCaptureFromBase64String(failedScreenShot, "screenshot").getModel().getMedia().get(0));
    }
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " test has passed");
        getTest().log(Status.PASS, "Test passed");
    }

}
