package ru.testing.suites.callsuite;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import ru.testing.AndroidTestSetUp;
import ru.testing.Utils;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public abstract class AbstractCallTest extends AndroidTestSetUp {
    private final static String declineButtonUnLocked = "com.android.incallui:id/declinebutton";

    @SneakyThrows
    @Disabled
    @Test
    public void incomingCall() {
        Utils utils = new Utils();
        utils.waitDeclineButton(driver, declineButtonUnLocked);
    }

    @Test()
    public void click() {
        WebElement webElement = driver.findElementByXPath("//android.widget.TextView[@text='Предпочтительная сеть: только GSM']");
        assertThat(webElement, is(true));
        System.out.println(webElement);
        driver.runAppInBackground(Duration.ofSeconds(-1));
        wait.implicitWait(driver, 10);
//        driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Телефон\"]").click();
        driver.findElementByAccessibilityId("Телефон").click();
        //TODO: -change to your language AccessibilityId, or find new locator and make change
//        driver.findElementById("com.android.contacts:id/contacts_dialpad_eight").click();
//        driver.findElementById("com.android.contacts:id/contacts_dialpad_nine").click();
//        driver.findElementById("com.android.contacts:id/contacts_dialpad_two").click();
//        driver.findElementById("com.android.contacts:id/contacts_dialpad_six").click();
//        driver.findElementById("com.android.contacts:id/contacts_dialpad_two").click();
//        driver.findElementById("com.android.contacts:id/contacts_dialpad_zero").click();
//        driver.findElementById("com.android.contacts:id/contacts_dialpad_zero").click();
//        driver.findElementById("com.android.contacts:id/contacts_dialpad_zero").click();
//        driver.findElementById("com.android.contacts:id/contacts_dialpad_zero").click();
//        driver.findElementById("com.android.contacts:id/contacts_dialpad_nine").click();
//        driver.findElementById("com.android.contacts:id/contacts_dialpad_nine").click();
//        driver.findElementById("com.android.contacts:id/dialButton").click();
//        Thread.sleep(3000);
//        driver.findElementById("com.android.incallui:id/endButton").click();
//        Allure.addAttachment("Any text", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

    }
}
