package ru.testing.page_objects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApnPage {
    @FindBy(id = "com.android.settings:id/konw_more")
    private WebElement searchBox;
    @FindBy(id = "com.android.chrome:id/search_box_text")
    private WebElement chromeSurf;
    @FindBy(id = "com.android.chrome:id/line_2")
    private WebElement siteClick;
    @FindBy(id = "com.android.chrome:id/home_button")
    private WebElement homeButton;

    public ApnPage(AndroidDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public void clickOnSearch() {
        searchBox.click();
    }
    public void chromeSurf() {
        chromeSurf.sendKeys("yandex.ru");
    }
    public void siteClick() {
        siteClick.click();
    }
    public void goHomeChome() {
        homeButton.click();
    }
}
