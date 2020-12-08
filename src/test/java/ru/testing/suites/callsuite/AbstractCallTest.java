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
import ru.testing.page_objects.CallPage;
import ru.testing.page_objects.MainPage;
import ru.testing.page_objects.SmsPage;

import java.time.Duration;

public abstract class AbstractCallTest extends AndroidTestSetUp {
    private static final String MESSAGE_PACKAGE = "com.google.android.apps.messaging";
    private static final String MESSAGE_ACTIVITY = "com.google.android.apps.messaging.ui.ConversationListActivity";
    private static final String PREFERRED_NW_PACKAGE = "com.android.phone";
    private static final String PREFERRED_NW_ACTIVITY = "com.android.phone.settings.PreferredNetworkTypeListPreference";
    private final static String declineButtonUnLocked = "com.android.incallui:id/declinebutton";
    private static CallPage callPage;
    private static SmsPage smsPage;
    private static MainPage mainPage;

    private MainPage mainPage() {
        if (mainPage == null) {
            mainPage = new MainPage(driver);
        }
        return mainPage;
    }

    private CallPage callPage() {
        if (callPage == null) {
            callPage = new CallPage(driver);
        }
        return callPage;
    }

    private SmsPage smsPage() {
        if (smsPage == null) {
            smsPage = new SmsPage(driver);
        }
        return smsPage;
    }

    @Autowired
    Utils utils;

    @Disabled
    @SneakyThrows
    public void setUpTechnology() {
        wait.implicitWait(driver, 10);
        driver.pressKey(new KeyEvent(AndroidKey.WAKEUP));
        utils.launchActivity(driver, new Activity(PREFERRED_NW_PACKAGE, PREFERRED_NW_ACTIVITY));
    }

    @SneakyThrows
    public void incomingCall() {
        utils.waitDeclineButton(driver, declineButtonUnLocked);
    }

    @SneakyThrows
    public void callToDomesticNumber() {
        startingCall();
        TouchAction action = new TouchAction(driver);
        WebElement webElement = callPage().getZero();
        action.longPress(new LongPressOptions().withElement(new ElementOption().
                withElement(webElement))).perform();
        callPage().clickSeven();
        callPage().clickFour();
        callPage().clickNine();
        callPage().clickFive();
        callPage().clickFive();
        callPage().clickZero();
        callPage().clickZero();
        callPage().clickFive();
        callPage().clickFive();
        callPage().clickFive();
        callPage().clickZero();
        callPage().clickVoiceCallButton();
        Thread.sleep(10000);
        driver.pressKey(new KeyEvent(AndroidKey.ENDCALL));
        getCallRecord();
        AllureScreenshot.takeScreenshot("callToAutoDialer", driver);
    }

    @SneakyThrows
    public void callToAutoDialer() {
        startingCall();
        callPage().clickEight();
        callPage().clickNine();
        callPage().clickTwo();
        callPage().clickSix();
        callPage().clickTwo();
        callPage().clickZero();
        callPage().clickZero();
        callPage().clickZero();
        callPage().clickZero();
        callPage().clickNine();
        callPage().clickNine();
        callPage().clickVoiceCallButton();
        Thread.sleep(10000);
        driver.pressKey(new KeyEvent(AndroidKey.ENDCALL));
//        callPage().clickEndCallButton();
        getCallRecord();
        AllureScreenshot.takeScreenshot("callToAutoDialer", driver);
    }


    @SneakyThrows
    public void interruptedOutgoingSmsCall() {
        startingCall();
        callPage().clickEight();
        callPage().clickNine();
        callPage().clickTwo();
        callPage().clickSix();
        callPage().clickTwo();
        callPage().clickZero();
        callPage().clickZero();
        callPage().clickZero();
        callPage().clickZero();
        callPage().clickNine();
        callPage().clickNine();
        callPage().clickVoiceCallButton();
        Thread.sleep(1000);
        utils.launchActivity(driver, new Activity(MESSAGE_PACKAGE, MESSAGE_ACTIVITY));
        smsPage().clickNewMessage();
        smsPage().recipientsNumberFill();
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        smsPage().addRussianText();
        smsPage().sendSmsClick();
        Thread.sleep(5000);
        driver.pressKey(new KeyEvent(AndroidKey.ENDCALL));
    }

    @SneakyThrows
    public void callToInvalidNumber() {
        startingCall();
        callPage().clickEight();
        callPage().clickEight();
        callPage().clickEight();
        callPage().clickEight();
        callPage().clickVoiceCallButton();
        Thread.sleep(5000);
        driver.pressKey(new KeyEvent(AndroidKey.ENDCALL));
        driver.pressKey(new KeyEvent(AndroidKey.WAKEUP));
        getCallRecord();
        AllureScreenshot.takeScreenshot("callToInvalidNumber", driver);
    }

    @SneakyThrows
    public void dtmfCall() {
        startingCall();
        callPage().clickEight();
        callPage().clickEight();
        callPage().clickZero();
        callPage().clickZero();
        callPage().clickFour();
        callPage().clickFour();
        callPage().clickFour();
        callPage().clickFive();
        callPage().clickFive();
        callPage().clickFive();
        callPage().clickFive();
        callPage().clickVoiceCallButton();
        Thread.sleep(40000);
        callPage().clickKeyboard();
        callPage().clickSix();
        Thread.sleep(5000);
        callPage().clickEndCallButton();
    }

    private void startingCall() {
        wait.implicitWait(driver, 10);
        driver.pressKey(new KeyEvent(AndroidKey.WAKEUP));
        driver.runAppInBackground(Duration.ofSeconds(-1));
        mainPage().clickOnPhone();
        callPage().clickDialPad();
    }

    public void getCallRecord() {
//        List<WebElement> callList = driver.findElementsById("com.google.android.dialer:id/new_call_log_recycler_view");
//        System.out.println(callList.get(0));
//        assertTrue(callList.get(0).isDisplayed());
    }
}