package ru.testing.suites.dataservicesuite;

import io.appium.java_client.android.Activity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.testing.AndroidTestSetUp;
import ru.testing.Utils.Utils;
import ru.testing.page_objects.ApnPage;

public class ApnInteractionTest extends AndroidTestSetUp {
    private static final String APP_PACKAGE = "com.android.settings";
    private static final String APP_ACTIVITY = "com.android.settings.Settings$ApnSettingsActivity";
    private static final String APP_PACKAGE_BROWSER = "com.android.chrome";
    private static final String APP_ACTIVITY_BROWSER = "com.google.android.apps.chrome.Main";
    private static ApnPage apnPage;

    @Autowired
    Utils utils;

    private ApnPage apnPage() {
        if (apnPage == null) {
            apnPage = new ApnPage(driver);
        }
        return apnPage;
    }

    @Test
    public void apnSetting() {
        wait.implicitWait(driver, 10);
        utils.launchActivity(driver, new Activity(APP_PACKAGE, APP_ACTIVITY));
        apnPage().clickOnSearch();
        utils.launchActivity(driver, new Activity(APP_PACKAGE_BROWSER, APP_ACTIVITY_BROWSER));
        apnPage().goHomeChome();
        apnPage().chromeSurf();
        apnPage().siteClick();
    }
}
