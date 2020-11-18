package ru.testing.suites.callsuite;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import static ru.testing.settings.SetProperties.locatorProperties;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.testing.AndroidTestSetUp;
import ru.testing.Application;
import ru.testing.settings.AndroidDriverConfigurator;
import ru.testing.settings.AndroidDriverInitializer;
import ru.testing.steps.CallSteps;

import java.time.Duration;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
@SpringBootTest(classes = Application.class)
public class WCDMACallTest extends AndroidTestSetUp {

    @SneakyThrows
    @Test()
    public void setUpTechnology()  {
        wait.implicitWait(driver, 10);
        callSteps.scrollBySwipeToDirection(false, driver);
        driver.findElementByXPath(locatorProperties().getProperty("choose_RAT")).click();
        driver.findElementByXPath("//android.widget.CheckedTextView[@index='2']").click(); // 0->4/3/2G, 1->3/2G, 2->3G only 4-GSM only
        driver.runAppInBackground(Duration.ofSeconds(-1));
    }

//      @Test()
//    public void click() throws Exception {
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
////        saveFailureScreenshot(driver);
//    }


}