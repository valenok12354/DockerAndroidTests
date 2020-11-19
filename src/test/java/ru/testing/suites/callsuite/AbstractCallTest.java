package ru.testing.suites.callsuite;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Allure;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import ru.testing.AndroidTestSetUp;
import ru.testing.Utils.Utils;
import ru.testing.page_objects.SmsPage;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class AbstractCallTest extends AndroidTestSetUp {
    private final static String declineButtonUnLocked = "com.android.incallui:id/declinebutton";
    @Autowired
    Utils utils;

    @SneakyThrows
    @Disabled
    @Test
    public void incomingCall() {
        utils.waitDeclineButton(driver, declineButtonUnLocked);
    }

    @SneakyThrows
    public void callToAutoDialer() {
        driver.runAppInBackground(Duration.ofSeconds(-1));
        wait.implicitWait(driver, 10);
        driver.findElementByAccessibilityId("Телефон").click();
        //TODO: -change to your language AccessibilityId, or find new locator and make change
        driver.findElementById("com.android.contacts:id/contacts_dialpad_eight").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_nine").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_two").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_six").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_two").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_zero").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_zero").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_zero").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_zero").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_nine").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_nine").click();
        driver.findElementById("com.android.contacts:id/dialButton").click();
        Thread.sleep(30000);
        driver.findElementById("com.android.incallui:id/endButton").click();
        getCallRecord();
        takeScreenshot("callToAutoDialer");
    }

    @SneakyThrows
    public void interruptedOutgoingSmsCall() {
        driver.runAppInBackground(Duration.ofSeconds(-1));
        wait.implicitWait(driver, 10);
        driver.findElementByAccessibilityId("Сообщения").click();
        SmsPage smsPage = new SmsPage(driver);
        smsPage.clickNewMessage();
        smsPage.recipientsNumberFill();
        smsPage.addRussianText();
        driver.runAppInBackground(Duration.ofSeconds(-1));
        driver.findElementByAccessibilityId("Телефон").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_zero").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_six").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_seven").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_four").click();
        driver.findElementById("com.android.contacts:id/dialButton").click();
        Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
        driver.findElementByAccessibilityId("Сообщения").click();
        smsPage.sendSmsClick();
    }

    @SneakyThrows
    public void callToInvalidNumber() {
        driver.runAppInBackground(Duration.ofSeconds(-1));
        wait.implicitWait(driver, 10);
        driver.findElementByAccessibilityId("Телефон").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_eight").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_eight").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_eight").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_eight").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_eight").click();
        driver.findElementById("com.android.contacts:id/contacts_dialpad_eight").click();
        driver.findElementById("com.android.contacts:id/dialButton").click();
        Thread.sleep(3000);
        driver.findElementById("com.android.incallui:id/endButton").click();
        getCallRecord();
        takeScreenshot("callToInvalidNumber");
    }


    private void getCallRecord() {
        driver.findElementByAccessibilityId("Телефон").click();
        List<WebElement> list = driver.findElementsById("com.android.contacts:id/primary_action_view");
        assertTrue(list.get(0).isDisplayed());
    }

    private void takeScreenshot(String name) {
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES)));
    }
}
