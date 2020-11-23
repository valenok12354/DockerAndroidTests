package ru.testing.suites.smssuite;

import io.appium.java_client.android.Activity;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.testing.AndroidTestSetUp;
import ru.testing.Utils.Utils;
import ru.testing.page_objects.SmsPage;

public class SmsTest extends AndroidTestSetUp {
    private static final String APP_PACKAGE = "com.android.mms";
    private static final String APP_ACTIVITY = "com.android.mms.ui.ConversationList";
    private static final String DECLINE_SMS = "com.android.incallui:id/mmsbutton";
    private static SmsPage smsPage;

    @Autowired
    Utils utils;

    private SmsPage smsPage() {
        if (smsPage == null) {
            smsPage = new SmsPage(driver);
        }
        return smsPage;
    }

    @Test
    public void newSms() {
        wait.implicitWaitMainScreen(driver, 10);
        utils.launchActivity(driver, new Activity(APP_PACKAGE, APP_ACTIVITY));
        smsPage().clickNewMessage();
        smsPage().recipientsNumberFill();
        smsPage().addRussianText();
        smsPage().sendSmsClick();
    }

//    @Test
//    public void smsDuringCall() {
//        interruptedOutgoingSmsCall();
//    }

    @SneakyThrows
    @Test
    public void smsDeclineCall() {
        wait.implicitWaitMainScreen(driver, 10);
        utils.waitRejectSms(driver, DECLINE_SMS);
        Thread.sleep(1000);
        driver.findElementById(DECLINE_SMS).click();
//        driver.findElementById("android:id/text1").click();
//        smsPage.callSmsClick();
//        smsPage.declineSmsTextClick();
    }

}