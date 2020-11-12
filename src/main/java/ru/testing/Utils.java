package ru.testing;

import io.appium.java_client.android.AndroidDriver;

public class Utils {
    public Boolean waitUntilDisplayed(AndroidDriver driver, String locator, Boolean displayed, int maxSecondsToWait) throws InterruptedException {
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

    public void waitDeclineButton(AndroidDriver driver, String searchUnLockedlocator) throws InterruptedException {
        if (waitUntilDisplayed(driver, searchUnLockedlocator, true, 15)) {
            findElementById(driver, searchUnLockedlocator);
        }
    }
}
