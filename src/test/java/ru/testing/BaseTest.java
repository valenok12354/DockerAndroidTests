//package ru.testing;
//
//import io.appium.java_client.android.AndroidDriver;
//import io.qameta.allure.Attachment;
//import org.junit.Rule;
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.junit.jupiter.api.extension.TestWatcher;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//
//import java.util.Optional;
//
//public class BaseTest {
//
//    @Rule
//    public TestWatcher screenshotOnFailure = new TestWatcher() {
//        @Override
//        public void testDisabled(ExtensionContext context, Optional<String> reason) {
//
//        }
//
//        @Override
//        public void testSuccessful(ExtensionContext context) {
//
//        }
//
//        @Override
//        public void testAborted(ExtensionContext context, Throwable cause) {
//
//        }
//
//        @Override
//        public void testFailed(ExtensionContext context, Throwable cause) {
//            makeScreenshotOnFailure();
//        }
//
//        @Attachment("Screenshot on failure")
//        public byte[] makeScreenshotOnFailure() {
//            return ((TakesScreenshot) AndroidDriver.getDriver()).getScreenshotAs(OutputType.BYTES);
//        }
//    };
//}
