package ru.testing.suites.ImsSuite;

import io.appium.java_client.android.Activity;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.testing.AllureScreenshot;
import ru.testing.AndroidTestSetUp;
import ru.testing.Utils.Utils;
import ru.testing.page_objects.SettingsPage;

public class IMSTest extends AndroidTestSetUp {
    private static final String SIM_SETTINGS_PACKAGE = "com.android.phone";
    private static final String SIM_SETTINGS_ACTIVITY = "com.android.phone.settings.MobileNetworkSettings";
    private static SettingsPage settingsPage;

    private SettingsPage settingsPage() {
        if (settingsPage == null) {
            settingsPage = new SettingsPage(driver);
        }
        return settingsPage;
    }

    @Autowired
    Utils utils;

    @SneakyThrows
    @Test
    public void volteSwitch() {
        wait.implicitWaitMainScreen(driver, 10);
        utils.launchActivity(driver, new Activity(SIM_SETTINGS_PACKAGE, SIM_SETTINGS_ACTIVITY));
        if (settingsPage().isSim1Exists()) {
            settingsPage().sim2SettingsClick();
        } else if (settingsPage().isSim2Exists()) {
            settingsPage().sim1SettingsClick();
        } else wait.implicitWait(driver, 10);
        settingsPage().sim1SettingsClick();
        //ToDo: make check in a status bar by opencv4nodejs or other snapshot tool.
        if (settingsPage().isBoxCheckON()) {
            settingsPage().checkBoxClick();
            AllureScreenshot.takeScreenshot("volteShouldBeOn", driver);
        } else if (settingsPage().isBoxCheckOFF()) {
            settingsPage().checkBoxClick();
            AllureScreenshot.takeScreenshot("volteShouldBeOFF", driver);
        }
    }
}