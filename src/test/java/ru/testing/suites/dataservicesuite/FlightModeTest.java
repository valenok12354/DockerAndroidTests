package ru.testing.suites.dataservicesuite;

import io.appium.java_client.android.Activity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.testing.AllureScreenshot;
import ru.testing.Utils.Utils;
import ru.testing.page_objects.SmsPage;
import ru.testing.suites.callsuite.AbstractCallTest;

public class FlightModeTest extends AbstractCallTest {
    private static final String APP_PACKAGE = "com.android.mms";
    private static final String APP_ACTIVITY = "com.android.mms.ui.ConversationList";
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
    public void callingFM(){
        wait.implicitWait(driver,10);
        driver.toggleAirplaneMode();
        endlessAutoCall();
        AllureScreenshot.takeScreenshot("flightModeCallScreen",driver);
        driver.findElementById("android:id/button1").click();
        utils.launchActivity(driver, new Activity(APP_PACKAGE, APP_ACTIVITY));
        smsPage().clickNewMessage();
        smsPage().recipientsNumberFill();
        smsPage().addRussianText();
        smsPage().sendSmsClick();
    }
}