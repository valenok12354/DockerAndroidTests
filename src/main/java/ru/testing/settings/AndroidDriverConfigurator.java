package ru.testing.settings;

import io.appium.java_client.remote.MobileCapabilityType;
import lombok.SneakyThrows;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Component;

import static ru.testing.settings.SetProperties.deviceProperties;

@Component
public class AndroidDriverConfigurator {

    @SneakyThrows
    public DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
                deviceProperties().getProperty("platform_version"));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceProperties().getProperty("device_name"));
        capabilities.setCapability("appPackage", deviceProperties().getProperty("app_package"));
        capabilities.setCapability("appActivity", deviceProperties().getProperty("app_activity"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        return capabilities;
    }

}

