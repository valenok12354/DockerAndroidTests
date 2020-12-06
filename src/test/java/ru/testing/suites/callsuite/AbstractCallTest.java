package ru.testing.suites.callsuite;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import ru.testing.AllureScreenshot;
import ru.testing.AndroidTestSetUp;
import ru.testing.Utils.Utils;
import ru.testing.page_objects.SmsPage;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class AbstractCallTest extends AndroidTestSetUp {
    private static final String APP_PACKAGE = "com.android.phone";
    private static final String APP_ACTIVITY = "com.android.phone.settings.PreferredNetworkTypeListPreference";
    private final static String declineButtonUnLocked = "com.android.incallui:id/declinebutton";
    @Autowired
    Utils utils;

    @Disabled
    @SneakyThrows
    public void setUpTechnology() {
        wait.implicitWait(driver, 10);
        utils.launchActivity(driver, new Activity(APP_PACKAGE, APP_ACTIVITY));
    }

    @SneakyThrows
    public void incomingCall() {
        utils.waitDeclineButton(driver, declineButtonUnLocked);
    }

    @SneakyThrows
    public void callToDomesticNumber() {
        driver.runAppInBackground(Duration.ofSeconds(-1));
        wait.implicitWait(driver, 10);
        driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Телефон\"]").click();
        driver.findElementById("com.google.android.dialer:id/dialpad_fab").click();
        TouchAction action = new TouchAction(driver);
        WebElement webElement = driver.findElementById("com.google.android.dialer:id/zero");
        action.longPress(new LongPressOptions().withElement(new ElementOption().
                withElement(webElement))).perform();
        driver.findElementById("com.google.android.dialer:id/seven").click();
        driver.findElementById("com.google.android.dialer:id/four").click();
        driver.findElementById("com.google.android.dialer:id/nine").click();
        driver.findElementById("com.google.android.dialer:id/five").click();
        driver.findElementById("com.google.android.dialer:id/five").click();
        driver.findElementById("com.google.android.dialer:id/zero").click();
        driver.findElementById("com.google.android.dialer:id/zero").click();
        driver.findElementById("com.google.android.dialer:id/five").click();
        driver.findElementById("com.google.android.dialer:id/five").click();
        driver.findElementById("com.google.android.dialer:id/five").click();
        driver.findElementById("com.google.android.dialer:id/zero").click();
        driver.findElementById("com.google.android.dialer:id/dialpad_voice_call_button").click();
        Thread.sleep(30000);
        driver.findElementById("com.google.android.dialer:id/incall_end_call").click();
        getCallRecord();
        AllureScreenshot.takeScreenshot("callToAutoDialer", driver);
    }

    @SneakyThrows
    public void callToAutoDialer() {
        driver.runAppInBackground(Duration.ofSeconds(-1));
        wait.implicitWait(driver, 10);
        driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Телефон\"]").click();
        driver.findElementById("com.google.android.dialer:id/dialpad_fab").click();
        //TODO: -change to your language AccessibilityId, or find new locator and make change
        driver.findElementById("com.google.android.dialer:id/eight").click();
        driver.findElementById("com.google.android.dialer:id/nine").click();
        driver.findElementById("com.google.android.dialer:id/two").click();
        driver.findElementById("com.google.android.dialer:id/six").click();
        driver.findElementById("com.google.android.dialer:id/two").click();
        driver.findElementById("com.google.android.dialer:id/zero").click();
        driver.findElementById("com.google.android.dialer:id/zero").click();
        driver.findElementById("com.google.android.dialer:id/zero").click();
        driver.findElementById("com.google.android.dialer:id/zero").click();
        driver.findElementById("com.google.android.dialer:id/nine").click();
        driver.findElementById("com.google.android.dialer:id/nine").click();
        driver.findElementById("com.google.android.dialer:id/dialpad_voice_call_button").click();
        Thread.sleep(30000);
        driver.findElementById("com.google.android.dialer:id/incall_end_call").click();
        getCallRecord();
        AllureScreenshot.takeScreenshot("callToAutoDialer", driver);
    }

    @SneakyThrows
    public void interruptedOutgoingSmsCall() {
        wait.implicitWait(driver, 10);
        driver.runAppInBackground(Duration.ofSeconds(-1));
        driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Телефон\"]").click();
        driver.findElementById("com.google.android.dialer:id/dialpad_fab").click();
        //TODO: -change to your language AccessibilityId, or find new locator and make change
        driver.findElementById("com.google.android.dialer:id/eight").click();
        driver.findElementById("com.google.android.dialer:id/nine").click();
        driver.findElementById("com.google.android.dialer:id/two").click();
        driver.findElementById("com.google.android.dialer:id/six").click();
        driver.findElementById("com.google.android.dialer:id/two").click();
        driver.findElementById("com.google.android.dialer:id/zero").click();
        driver.findElementById("com.google.android.dialer:id/zero").click();
        driver.findElementById("com.google.android.dialer:id/zero").click();
        driver.findElementById("com.google.android.dialer:id/zero").click();
        driver.findElementById("com.google.android.dialer:id/nine").click();
        driver.findElementById("com.google.android.dialer:id/nine").click();
        driver.findElementById("com.google.android.dialer:id/dialpad_voice_call_button").click();
        Thread.sleep(2000);
        utils.launchActivity(driver, new Activity("com.google.android.apps.messaging", "com.google.android.apps.messaging.ui.ConversationListActivity"));
        SmsPage smsPage = new SmsPage(driver);
        smsPage.clickNewMessage();
        smsPage.recipientsNumberFill();
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        smsPage.addRussianText();
        smsPage.sendSmsClick();
        utils.launchActivity(driver, new Activity( "com.google.android.dialer","com.google.android.dialer.extensions.GoogleDialtactsActivity" ));
        getCallRecord();
        
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


    public void getCallRecord() {
        List<WebElement> callList = driver.findElementsById("com.google.android.dialer:id/new_call_log_recycler_view");
        System.out.println(callList.get(0));
        assertTrue (callList.get(0).isDisplayed());
    }
}