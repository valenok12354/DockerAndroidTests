package ru.testing;

import io.appium.java_client.android.AndroidDriver;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Component
public class ImplicitWait {

    public void implicitWait(AndroidDriver driver, long time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

    }

    public void implicitWaitMainScreen(AndroidDriver driver, long time) {
        driver.runAppInBackground(Duration.ofSeconds(-1));
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
}
