package Tests;

import BasesClasses.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AppTest extends TestBase {

    private static Logger log = LogManager.getLogger(AppTest.class);

    @Test
    public void validateAppLaunch() {
        log.info("Inside AppTest");
        driver.findElement(By.xpath("//*[contain (@text, 'app')]"));
        sleep(20);
    }
}
