package ru.testing.page_objects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Телефон\"]")
    private WebElement phone;
    //TODO: -change to your language AccessibilityId, or find new locator and make change

    public MainPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickOnPhone() {
        phone.click();
    }
}
