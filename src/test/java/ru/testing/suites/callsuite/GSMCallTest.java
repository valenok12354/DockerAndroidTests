package ru.testing.suites.callsuite;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import org.springframework.boot.test.context.SpringBootTest;
import ru.testing.Application;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
@SpringBootTest(classes = Application.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GSMCallTest extends AbstractCallTest {

    @Test
    @Order(1)
    @Override
    public void setUpTechnology() {
        super.setUpTechnology();
        driver.findElementByXPath("//android.widget.CheckedTextView[@index='3']").click(); // 0->4/3/2G, 1->3/2G, 2->3G only 3-GSM only
        WebElement webElement = driver.findElementByXPath("//android.widget.TextView[@text='Предпочтительная сеть: только GSM']");
        assertThat(webElement.getText(), is("Предпочтительная сеть: только GSM"));
    }

    @Disabled
    @Test
    @Override
    public void callToAutoDialer() {
        super.callToAutoDialer();
    }

    @Test
    @Override
    public void callToInvalidNumber() {
        super.callToInvalidNumber();
    }

    @Test
    @Override
    public void callToDomesticNumber() {
        super.callToDomesticNumber();
    }
}