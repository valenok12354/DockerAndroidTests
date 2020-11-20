package ru.testing.page_objects;

import io.appium.java_client.android.AndroidDriver;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Getter
public class CallPage {
    @FindBy(id = "com.android.incallui:id/holdButton")
    private WebElement holdButton;

    public CallPage(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnHold() {
        holdButton.click();
    }
}
