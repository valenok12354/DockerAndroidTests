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

import lombok.Getter;
import lombok.SneakyThrows;
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

import java.time.Duration;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
@SpringBootTest(classes = Application.class)
public class AndroidTestSetUp {
    @Autowired
    public AndroidDriverInitializer androidDriverInitializer;
    @Autowired
    public AndroidDriverConfigurator androidDriverConfigurator;
    @Autowired
    public CallSteps callSteps;
    @Autowired
    public ImplicitWait wait;
    public AndroidDriver driver;

    @SneakyThrows
    @BeforeAll
    public void initializeDriverAndCleanUp() {
        driver = androidDriverInitializer.initializeAndroidDriver(androidDriverConfigurator.getDesiredCapabilities());
        wait.implicitWait(driver, 10);
        callSteps.airplaneModeOnOff(driver);
    }
}