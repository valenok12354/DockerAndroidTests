package ru.testing.suites.callsuite;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import lombok.SneakyThrows;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import ru.testing.AllureScreenshot;
import ru.testing.AndroidTestSetUp;
import ru.testing.Utils.Utils;
import ru.testing.page_objects.CallPage;
import ru.testing.page_objects.SmsPage;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class AbstractCallTest extends AndroidTestSetUp {
    private final static String declineButtonUnLocked = "com.android.incallui:id/declinebutton";
    @Autowired
    Utils utils;

    @SneakyThrows
    public void incomingCall() {
        utils.waitDeclineButton(driver, declineButtonUnLocked);
    }

    @SneakyThrows
    public void callToDomesticNumber() {
        driver.runAppInBackground(Duration.ofSeconds(-1));
        wait.implicitWait(driver, 10);
        driver.findElementByAccessibilityId("Телефон").click();
        TouchAction action = new TouchAction(driver);
        WebElement webElement = driver.findElementById("com.android.contacts:id/contacts_dialpad_zero");
        action.longPress(new LongPressOptions().withElement(new ElementOption().
                withElement(webElement))).perform();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_seven").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_four").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_nine").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_five").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_five").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_zero").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_zero").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_five").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_five").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_five").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_zero").click();
        driver.findElementById("com.android.contacts:id/dialButton").click();
        Thread.sleep(30000);
        driver.findElementById("com.android.incallui:id/endButton").click();
        getCallRecord();
        AllureScreenshot.takeScreenshot("callToAutoDialer", driver);
    }

    @SneakyThrows
    public void callToAutoDialer() {
        driver.runAppInBackground(Duration.ofSeconds(-1));
        wait.implicitWait(driver, 10);
        driver.findElementByAccessibilityId("Телефон").click();
        //TODO: -change to your language AccessibilityId, or find new locator and make change
        driver.findElementById("com.android.contacts:id/contacts_dialpad_eight").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_nine").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_two").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_six").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_two").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_zero").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_zero").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_zero").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_zero").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_nine").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_nine").click();
        driver.findElementById("com.android.contacts:id/dialButton").click();
        Thread.sleep(30000);
        driver.findElementById("com.android.incallui:id/endButton").click();
        getCallRecord();
        AllureScreenshot.takeScreenshot("callToAutoDialer", driver);
    }

    public void endlessAutoCall() {
        driver.runAppInBackground(Duration.ofSeconds(-1));
        driver.findElementByAccessibilityId("Телефон").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_zero").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_six").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_seven").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_four").click();
        driver.findElementById("com.android.contacts:id/dialButton").click();
    }

    @SneakyThrows
    public void autoHelpCall() {
        CallPage callPage = new CallPage(driver);
        endlessAutoCall();
        Thread.sleep(5000);
        callPage.clickOnHold();
    }

    @SneakyThrows
    public void interruptedOutgoingSmsCall() {
        driver.runAppInBackground(Duration.ofSeconds(-1));
        wait.implicitWait(driver, 10);
        driver.findElementByAccessibilityId("Сообщения").click();
        SmsPage smsPage = new SmsPage(driver);
        smsPage.clickNewMessage();
        smsPage.recipientsNumberFill();
        smsPage.addRussianText();
        autoHelpCall();
        Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
        driver.findElementByAccessibilityId("Сообщения").click();
        smsPage.sendSmsClick();
    }

    @SneakyThrows
    public void callToInvalidNumber() {
        driver.runAppInBackground(Duration.ofSeconds(-1));
        wait.implicitWait(driver, 10);
        driver.findElementByAccessibilityId("Телефон").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_eight").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_eight").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_eight").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_eight").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_eight").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_eight").click();
        driver.findElementById("com.android.contacts:id/dialButton").click();
        Thread.sleep(3000);
        driver.findElementById("com.android.incallui:id/endButton").click();
        getCallRecord();
        AllureScreenshot.takeScreenshot("callToInvalidNumber", driver);
    }
    private void getCallRecord() {
        driver.findElementByAccessibilityId("Телефон").click();
        List<WebElement> list = driver.findElementsById("com.android.contacts:id/primary_action_view");
        assertTrue(list.get(0).isDisplayed());
    }
}
