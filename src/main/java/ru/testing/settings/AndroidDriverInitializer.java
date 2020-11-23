package ru.testing.settings;

import io.appium.java_client.android.AndroidDriver;
import lombok.SneakyThrows;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Component;

import java.net.URL;

@Component
public class AndroidDriverInitializer {
    @SneakyThrows
    public AndroidDriver initializeAndroidDriver(DesiredCapabilities capabilities) throws Exception{
        return new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }
}