package ru.testing.suites.callsuite;


import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import ru.testing.AndroidTestSetUp;
import ru.testing.Application;

import java.time.Duration;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
@SpringBootTest(classes = Application.class)
public class WCDMACallTest extends AndroidTestSetUp {

    @SneakyThrows
    @Test()
    public void setUpTechnology() {
        wait.implicitWait(driver, 10);
        callSteps.scrollBySwipeToDirection(false, driver);
        driver.findElementByXPath("//android.widget.CheckedTextView[@index='2']").click(); // 0->4/3/2G, 1->3/2G, 2->3G only 4-GSM only
        driver.runAppInBackground(Duration.ofSeconds(-1));
    }
}