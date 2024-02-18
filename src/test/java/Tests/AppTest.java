package Tests;

import BasesClasses.TestBase;
import Pages.ApiDemoPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class AppTest extends TestBase {

    private static Logger log = LogManager.getLogger(AppTest.class);

    @Test
    public void validateAppLaunch() {
        log.info("Inside AppTest");
        ApiDemoPage apiDemoPage = new ApiDemoPage(driver);
        apiDemoPage.clickViewLink();
//        scrollToEnd("down");
//        scrollToText("Tabs");
        flingGesture(apiDemoPage.getGalleryElement(), "down");
        flingGesture(apiDemoPage.getGalleryElement(), "down");
        sleep(20);
    }
}
