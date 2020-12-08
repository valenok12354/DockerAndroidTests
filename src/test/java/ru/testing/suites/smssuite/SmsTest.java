package ru.testing.suites.smssuite;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.testing.AndroidTestSetUp;
import ru.testing.Utils.Utils;
import ru.testing.page_objects.SmsPage;

public class SmsTest extends AndroidTestSetUp {
    private static final String MESSAGE_PACKAGE = "com.google.android.apps.messaging";
    private static final String MESSAGE_ACTIVITY = "com.google.android.apps.messaging.ui.ConversationListActivity";
    private static final String DECLINE_SMS = "com.google.android.dialer:id/incall_data_container_chip_container";
    private static SmsPage smsPage;

    @Autowired
    Utils utils;

    private SmsPage smsPage() {
        if (smsPage == null) {
            smsPage = new SmsPage(driver);
        }
        return smsPage;
    }

    @Disabled
    @Test
    public void newSms() {
        wait.implicitWaitMainScreen(driver, 10);
        utils.launchActivity(driver, new Activity(MESSAGE_PACKAGE, MESSAGE_ACTIVITY));
        smsPage().clickNewMessage();
        smsPage().recipientsNumberFill();
        smsPage().addRussianText();
        smsPage().sendSmsClick();
    }

    @Test
    @SneakyThrows
    public void smsDeclineCall() {
        driver.pressKey(new KeyEvent(AndroidKey.POWER));
        wait.implicitWaitMainScreen(driver, 10);
        utils.waitRejectSms(driver, DECLINE_SMS);
        smsPage().willRecallPhrase();
    }
}