package ru.testing.suites.callsuite;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static ru.testing.settings.SetProperties.locatorProperties;

import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.testing.AndroidTestSetUp;
import ru.testing.Application;
import ru.testing.Utils;
import ru.testing.settings.AndroidDriverConfigurator;
import ru.testing.settings.AndroidDriverInitializer;
import ru.testing.steps.CallSteps;

import java.time.Duration;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
@SpringBootTest(classes = Application.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GSMCallTest extends AbstractCallTest {

    @SneakyThrows
    @Test()
    @Order(1)
    public void setUpTechnology() {
        wait.implicitWait(driver, 10);
        callSteps.scrollBySwipeToDirection(false, driver);
        driver.findElementByXPath(locatorProperties().getProperty("choose_RAT")).click();
        driver.findElementByXPath("//android.widget.CheckedTextView[@index='3']").click(); // 0->4/3/2G, 1->3/2G, 2->3G only 3-GSM only
//        driver.runAppInBackground(Duration.ofSeconds(-1));
    }

    @Test()
    public void click() {
        WebElement webElement = driver.findElementByXPath("//android.widget.TextView[@text='Предпочтительная сеть: только GSM']");
        assertThat(webElement.getText(), is("Предпочтительная сеть: только GSM" ));
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