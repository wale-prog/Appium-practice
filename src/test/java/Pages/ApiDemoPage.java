package Pages;

import BasesClasses.PageBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ApiDemoPage extends PageBase {

    public ApiDemoPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "Views")
    private WebElement viewLink;
    @AndroidFindBy(accessibility = "Gallery")
    private WebElement galleryElement;
    @AndroidFindBy(accessibility = "Accessibility")
    private WebElement accessibilityLink;

    public void clickViewLink() {
        click(viewLink);
    }
    public WebElement getGalleryElement() {
        return galleryElement;
    }
    public WebElement getAccessibilityLink() {
       return accessibilityLink;
    }

}
