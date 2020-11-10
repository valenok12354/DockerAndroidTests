package ru.testing;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import static ru.testing.settings.SetProperties.locatorProperties;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.testing.settings.AndroidDriverConfigurator;
import ru.testing.settings.AndroidDriverInitializer;
import ru.testing.steps.CallSteps;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
@SpringBootTest(classes = Application.class)
public class AndroidTest {
    @Autowired
    public AndroidDriverInitializer androidDriverInitializer;
    @Autowired
    public AndroidDriverConfigurator androidDriverConfigurator;
    @Autowired
    public CallSteps callSteps;
    @Autowired
    public ImplicitWait wait;
    private AndroidDriver driver;

    @BeforeAll
    public void initializeDriverAndInstallApp() throws Exception {
        driver = androidDriverInitializer.initializeAndroidDriver(androidDriverConfigurator.getDesiredCapabilities());

    }

//    @Test()
//    @Order(1)
//    public void cleanUp() {
//        callSteps.airplaneModeOnOff(driver);
//    }

    @Epic("Testing calls")
    @Feature("4G Testing")
    @Severity(SeverityLevel.MINOR)
    @Description("Dialing number")
    @Story(value = "Pure 4G call")
    @Test()
    public void setUpTechnology() throws Exception {
        wait.implicitWait(driver, 10);
        callSteps.scrollBySwipeToDirection(false, driver);
        driver.findElementByXPath(locatorProperties().getProperty("choose_RAT")).click();
        driver.findElementByXPath("//android.widget.CheckedTextView[@index='0']").click(); // 0->4/3/2G, 4-GSM only
    }
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

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveFailureScreenshot(AndroidDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}