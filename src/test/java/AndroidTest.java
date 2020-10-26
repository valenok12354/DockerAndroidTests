import com.google.common.cache.Weigher;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.android.GsmCallActions;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.MalformedURLException;
import java.net.URL;


public class AndroidTest {

    public static AndroidDriver<AndroidElement> driver;


    @Before
    public void dockerAlfa()  throws MalformedURLException{
        DesiredCapabilities capabilities = getDesiredCapabilities();
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }

    public DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "HUAWEI P8 lite 2017");
//        capabilities.setCapability(MobileCapabilityType.APP, myApp);
        capabilities.setCapability("appPackage", "com.android.contacts");
        capabilities.setCapability("appActivity", "com.android.contacts.activities.DialtactsActivity");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 220);
        capabilities.setCapability("deviceReadyTimeout", 5);
        return capabilities;
    }

    @Test
    public void click() {
        driver.findElement(By.xpath("//*[@id='usernameTextField']"))
              .click();
    }


}