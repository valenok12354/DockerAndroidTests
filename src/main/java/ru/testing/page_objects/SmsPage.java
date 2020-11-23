package ru.testing.page_objects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmsPage {

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Новое сообщение\"]")
    private WebElement newMessage;

    @FindBy(id = "com.android.mms:id/recipients_editor")
    private WebElement recipientsEdit;

    @FindBy(id = "com.android.mms:id/embedded_text_editor")
    private WebElement textEditor;

    @FindBy(id = "com.android.mms:id/send_button_sms")
    private WebElement sendSmsArrow;

    @FindBy(id = "com.android.incallui:id/mmsbutton")
    private WebElement mmsButton;

    @FindBy(id = "android:id/text1")
    private WebElement smsDeclineText;

    public SmsPage(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickNewMessage() {
        newMessage.click();
    }

    public void recipientsNumberFill() {
        recipientsEdit.sendKeys("89169269109");
    }

    public void addRussianText() { // TODO English or Chinese
        textEditor.sendKeys("Я узнал, что у меня есть огромная семья");
    }

    public void sendSmsClick() {
        sendSmsArrow.click();
    }

    public void callSmsClick() {
        mmsButton.click();
//        smsDeclineText.click();
    }

    public void declineSmsTextClick() {
        smsDeclineText.click();
    }
}
