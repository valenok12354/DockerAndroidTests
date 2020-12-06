package ru.testing.page_objects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmsPage {

    @AndroidFindBy(accessibility = "Начать чат")
    private WebElement newMessage;

    @FindBy(id = "com.google.android.apps.messaging:id/recipient_text_view")
    private WebElement recipientsEdit;

    @FindBy(id = "com.google.android.apps.messaging:id/compose_message_text")
    private WebElement textEditor;

    @FindBy(id = "com.google.android.apps.messaging:id/send_message_button_icon")
    private WebElement sendSmsArrow;

    @FindBy(id = "com.android.incallui:id/mmsbutton")
    private WebElement mmsButton;

    @FindBy(id = "android:id/text1")
    private WebElement smsDeclineText;

    public SmsPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickNewMessage() {
        newMessage.click();
    }

    public void recipientsNumberFill() {
        recipientsEdit.sendKeys("89264430587");
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
