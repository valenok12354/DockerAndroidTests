package ru.testing;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.testing.settings.AndroidDriverConfigurator;
import ru.testing.settings.AndroidDriverInitializer;

import java.io.ByteArrayInputStream;
import java.util.Optional;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
@SpringBootTest(classes = Application.class)
public class AndroidTest {

    @Autowired
    public AndroidDriverInitializer androidDriverInitializer;

    @Autowired
    public AndroidDriverConfigurator androidDriverConfigurator;

    private AndroidDriver driver;

    @BeforeAll
    public void initializeDriverAndInstallApp() throws Exception  {
        driver = androidDriverInitializer.initializeAndroidDriver(androidDriverConfigurator.getDesiredCapabilities());
    }

    @Epic("Testing calls")
    @Feature("4G Testing")
    @Severity(SeverityLevel.MINOR)
    @Description("Dialing number")
    @Story(value = "Pure 4G call")
    @Test()
    public void click() {
        driver.findElementById("com.android.contacts:id/contacts_dialpad_eight").click();

        Allure.addAttachment("Any text", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
//        saveFailureScreenshot(driver);
    }
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveFailureScreenshot(AndroidDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


}