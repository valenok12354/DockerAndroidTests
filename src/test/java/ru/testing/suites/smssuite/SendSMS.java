package ru.testing.suites.smssuite;

import io.appium.java_client.android.Activity;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.testing.AndroidTestSetUp;
import ru.testing.Application;
import ru.testing.Utils.Utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
@SpringBootTest(classes = Application.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SendSMS extends AndroidTestSetUp {

    private static final String APP_PACKAGE = "com.android.mms";
    private static final String APP_ACTIVITY = "com.android.mms.ui.ConversationList";

    @Autowired
    Utils utils;

    @Test
    public void sendSMS() {
        wait.implicitWaitMainScreen(driver, 10);
        utils.launchActivity(driver, new Activity(APP_PACKAGE, APP_ACTIVITY));
        driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Новое сообщение\"]").click();
        driver.findElementById("com.android.mms:id/recipients_editor").sendKeys("89169269109");
        driver.findElementById("com.android.mms:id/embedded_text_editor").
                sendKeys("Я узнал, что у меня есть огромная семья");
        driver.findElementById("com.android.mms:id/send_button_sms").click();
        driver.quit();
    }

    @Test
    @Order(1)
    @Override
    public void setUpTechnology() {
        super.setUpTechnology();
        driver.findElementByXPath("//android.widget.CheckedTextView[@index='3']").click(); // 0->4/3/2G, 1->3/2G, 2->3G only 3-GSM only
        WebElement webElement = driver.findElementByXPath("//android.widget.TextView[@text='Предпочтительная сеть: только GSM']");
        assertThat(webElement.getText(), is("Предпочтительная сеть: только GSM"));
    }
}
