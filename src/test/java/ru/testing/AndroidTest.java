package ru.testing;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.testing.settings.AndroidDriverConfigurator;
import ru.testing.settings.AndroidDriverInitializer;

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
    public void initializeDriverAndInstallApp() throws Exception {
        driver = androidDriverInitializer.initializeAndroidDriver(androidDriverConfigurator.getDesiredCapabilities());
    }

    @Test
    public void click() {
        driver.findElement(By.xpath("//*[@id='usernameTextField']"))
              .click();
    }


}