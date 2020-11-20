package ru.testing.suites.smssuite;

import io.appium.java_client.android.Activity;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.testing.Utils.Utils;
import ru.testing.page_objects.SmsPage;
import ru.testing.suites.callsuite.AbstractCallTest;

public class SmsTest extends AbstractCallTest {

    private static final String APP_PACKAGE = "com.android.mms";
    private static final String APP_ACTIVITY = "com.android.mms.ui.ConversationList";

    @Autowired
    Utils utils;

    @Test
    public void newSms() {
        SmsPage smsPage = new SmsPage(driver);
        wait.implicitWaitMainScreen(driver, 10);
        utils.launchActivity(driver, new Activity(APP_PACKAGE, APP_ACTIVITY));
        smsPage.clickNewMessage();
        smsPage.recipientsNumberFill();
        smsPage.addRussianText();
        smsPage.sendSmsClick();
    }

    @Test
    public void smsDuringCall() {
        interruptedOutgoingSmsCall();
    }
}