package ru.testing;

import io.appium.java_client.android.AndroidDriver;


import static ru.testing.settings.SetProperties.locatorProperties;

import lombok.SneakyThrows;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.testing.settings.AndroidDriverConfigurator;
import ru.testing.settings.AndroidDriverInitializer;
import ru.testing.steps.CallSteps;

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
//        callSteps.airplaneModeOnOff(driver);
    }

    @Disabled
    @SneakyThrows
    public void setUpTechnology() {
        wait.implicitWait(driver, 10);
        callSteps.scrollBySwipeToDirection(false, driver);
        driver.findElementByXPath(locatorProperties().getProperty("choose_RAT")).click();
    }

}