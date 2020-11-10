package ru.testing.steps;

import io.appium.java_client.IllegalCoordinatesException;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.springframework.stereotype.Component;

import java.time.Duration;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

@Component
public class CallSteps {

    public void airplaneModeOnOff(AndroidDriver driver){
        driver.toggleAirplaneMode();
        driver.toggleAirplaneMode();
    }

    public void scrollBySwipeToDirection(Boolean isSwipeDirectionUp, AndroidDriver driver) {
        int xOffsetHalf = driver.manage().window().getSize().width / 4;
        int yOffsetHalf = driver.manage().window().getSize().height / 4;

        PointOption destinationPoint = isSwipeDirectionUp ?
                point(xOffsetHalf, driver.manage().window().getSize().height - 1) :
                point(xOffsetHalf, 0);
        try {
            new TouchAction(driver)
                    .press(point(xOffsetHalf, yOffsetHalf))
                    .waitAction(waitOptions(Duration.ofMillis(300)))
                    .moveTo(destinationPoint)
                    .release()
                    .perform();
        } catch (IllegalCoordinatesException e) {
        }
    }

}
