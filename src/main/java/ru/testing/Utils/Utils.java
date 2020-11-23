package ru.testing.Utils;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.springframework.stereotype.Component;

@Component
public class Utils {
    public Boolean waitUntilDisplayed(AndroidDriver driver, String locator, Boolean displayed, int maxSecondsToWait) {
        long start = System.currentTimeMillis();
        boolean isDisplayed = false;
        do {
            try {
                driver.findElementById(locator);
                isDisplayed = true;
            } catch (Exception e) {
                isDisplayed = false;
            }
        } while (displayed != isDisplayed && (System.currentTimeMillis() - start) / 1000F < maxSecondsToWait);
        return isDisplayed;
    }

    public void findElementById(AndroidDriver driver, String searchLocator) {
        driver.findElementById(searchLocator).click();
    }

    public void waitDeclineButton(AndroidDriver driver, String searchUnLockedlocator) {
        if (waitUntilDisplayed(driver, searchUnLockedlocator, true, 10)) {
            findElementById(driver, searchUnLockedlocator);
        }
    }

    public void waitRejectSms(AndroidDriver driver, String searchSmsToDecline) {
        if (waitUntilDisplayed(driver, searchSmsToDecline, true, 10)) {
            findElementById(driver, searchSmsToDecline);
        }
    }
    public void launchActivity(AndroidDriver driver, Activity activityName) {
        driver.startActivity(activityName);
    }
}
