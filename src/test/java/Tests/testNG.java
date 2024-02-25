package Tests;

import BasesClasses.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

import static utils.extentReports.ExtentTestManager.startTest;

public class testNG extends TestBase {

    @Test(priority = 1, description = "Validate addition operator")
    public void assertion(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "testNG");

        Assert.assertTrue((6 + 3) == 9);
    }
}
