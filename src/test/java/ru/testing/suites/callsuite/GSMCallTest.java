package ru.testing.suites.callsuite;

import lombok.SneakyThrows;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import ru.testing.Application;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static ru.testing.settings.SetProperties.networkProperties;

@TestInstance(PER_CLASS)
@SpringBootTest(classes = Application.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GSMCallTest extends AbstractCallTest {
    private final static String NUMBER = "[4]";

    @Test
    @Order(1)
    @Override
    @SneakyThrows
    public void setUpTechnology() {
        super.setUpTechnology();
        driver.findElementByXPath(networkProperties().getProperty("Basic") + NUMBER).click(); // 1->5G, 2->LTE, 3->3G 4-GSM only
    }
    @Disabled
    @Test
    @Override
    public void callToAutoDialer() {
        super.callToAutoDialer();
    }
    @Disabled
    @Test
    @Override
    public void interruptedOutgoingSmsCall() {
        super.interruptedOutgoingSmsCall();
    }
    @Disabled
    @Test
    @Override
    public void callToInvalidNumber() {
        super.callToInvalidNumber();
    }
    @Disabled
    @Test
    @Override
    public void callToDomesticNumber() {
        super.callToDomesticNumber();
    }

    @Test
    @Override
    public void dtmfCall() {
        super.dtmfCall();
    }
}