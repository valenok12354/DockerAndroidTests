package ru.testing;

import io.appium.java_client.android.AndroidDriver;

public class Utils {
    public Boolean waitUntilDisplayed(AndroidDriver driver, String locator, Boolean displayed, int maxSecondsToWait) throws InterruptedException {
        long start = System.currentTimeMillis();
        boolean isDisplayed = false;
        do {
            try {
                driver.findElementById(locator);
                isDisplayed=true;
            } catch (Exception e) {
                isDisplayed=false;
            }
        } while (displayed!=isDisplayed && (System.currentTimeMillis()-start)/1000F<maxSecondsToWait);
        System.out.println("Time to wait "+locator+" to "+": "+(System.currentTimeMillis()-start)/1000F+" seconds. "
                +". Device "+driver.getCapabilities().getCapability("deviceName"));
        return isDisplayed;
    }
}
