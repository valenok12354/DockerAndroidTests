package ru.testing.page_objects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpeedTestPage {
    @FindBy(id = "org.zwanoo.android.speedtest:id/go_button")
    private WebElement goButton;
    @FindBy(id = "org.zwanoo.android.speedtest:id/suite_completed_feedback_assembly_test_again")
    private WebElement testAgain;

    public SpeedTestPage(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void goButtonClick() {
        goButton.click();
    }

    public void checkTheEndUL() {
        testAgain.isDisplayed();
    }
}