package ru.testing.page_objects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CallPage {
    @FindBy(id = "com.android.incallui:id/holdButton")
    private WebElement holdButton;

    @FindBy(id = "com.google.android.dialer:id/dialpad_fab")
    private WebElement dialpad;

    @FindBy(id = "com.google.android.dialer:id/dialpad_voice_call_button")
    private WebElement voiceCallButton;

    @FindBy(id = "com.google.android.dialer:id/zero")
    private WebElement zero;

    @FindBy(id = "com.google.android.dialer:id/one")
    private WebElement one;

    @FindBy(id = "com.google.android.dialer:id/two")
    private WebElement two;

    @FindBy(id = "com.google.android.dialer:id/three")
    private WebElement three;

    @FindBy(id = "com.google.android.dialer:id/four")
    private WebElement four;

    @FindBy(id = "com.google.android.dialer:id/five")
    private WebElement five;

    @FindBy(id = "com.google.android.dialer:id/six")
    private WebElement six;

    @FindBy(id = "com.google.android.dialer:id/seven")
    private WebElement seven;

    @FindBy(id = "com.google.android.dialer:id/eight")
    private WebElement eight;

    @FindBy(id = "com.google.android.dialer:id/nine")
    private WebElement nine;

    public CallPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickOnHold() {
        holdButton.click();
    }

    public void clickZero() {
        zero.click();
    }

    public void clickOne() {
        one.click();
    }

    public void clickTwo() {
        two.click();
    }

    public void clickThree() {
        three.click();
    }

    public void clickFour() {
        four.click();
    }

    public void clickFive() {
        five.click();
    }

    public void clickSix() {
        six.click();
    }

    public void clickSeven() {
        seven.click();
    }

    public void clickEight() {
        eight.click();
    }

    public void clickNine() {
        nine.click();
    }

    public void clickDialPad() {
        dialpad.click();
    }

    public void clickVoiceCallButton() {
        voiceCallButton.click();
    }
}
