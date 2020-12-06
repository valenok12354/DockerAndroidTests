package ru.testing.settings;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SetProperties {

    public static Properties deviceProperties() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream("device.properties");
        properties.load(inputStream);
        return  properties;
    }
    public static Properties networkProperties() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream("network.properties");
        properties.load(inputStream);
        return  properties;
    }
}
