package ru.testing.suites;

import io.appium.java_client.android.Activity;
import lombok.SneakyThrows;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import ru.testing.AllureScreenshot;
import ru.testing.AndroidTestSetUp;
import ru.testing.Utils.Utils;
import ru.testing.page_objects.SpeedTestPage;

public class SpeedTestTest extends AndroidTestSetUp {
    private static final String APP_PACKAGE = "org.zwanoo.android.speedtest";
    private static final String APP_ACTIVITY = "com.ookla.mobile4.screens.main.MainViewActivity";

    @Autowired
    Utils utils;

    @SneakyThrows
    @RepeatedTest(2)
    public void speedTestStart() {
        SpeedTestPage speedTestPage = new SpeedTestPage(driver);
        wait.implicitWaitMainScreen(driver, 10);
        utils.launchActivity(driver, new Activity(APP_PACKAGE, APP_ACTIVITY));
        speedTestPage.goButtonClick();
        wait.implicitWait(driver, 35);
        speedTestPage.checkTheEndUL();
        AllureScreenshot.takeScreenshot("speedTest screenshot", driver);
    }
}