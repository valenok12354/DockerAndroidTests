package ru.testing.page_objects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage {
    @FindBy(id = "com.android.settings:id/konw_more")
    private WebElement searchBox;
    @FindBy(id = "com.android.chrome:id/search_box_text")
    private WebElement chromeSurf;
    @FindBy(id = "com.android.chrome:id/line_2")
    private WebElement siteClick;
    @FindBy(id = "com.android.chrome:id/home_button")
    private WebElement homeButton;
    //ToDo Find better locator
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/" +
            "android.widget.FrameLayout[2]/android.widget.LinearLayout/android.view.ViewGroup/" +
            "androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[6]/" +
            "android.widget.LinearLayout/android.widget.CheckBox")
    private WebElement volteCheckBox;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/" +
            "android.widget.FrameLayout[2]/android.widget.LinearLayout/" +
            "android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/" +
            "android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/" +
            "android.widget.LinearLayout/android.widget.TextView[1]")
    private WebElement sim1;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/" +
            "android.widget.FrameLayout[2]/android.widget.LinearLayout/" +
            "android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/" +
            "android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/" +
            "android.widget.LinearLayout/android.widget.TextView[1]")
    private WebElement sim2;
    @FindBy(id = "com.android.phone:id/sim_1")
    private WebElement sim1Settings;
    @FindBy(id = "com.android.phone:id/sim_2")
    private WebElement sim2Settings;

    public SettingsPage(AndroidDriver driver) {

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

    public boolean isBoxCheckON() {
        return volteCheckBox.getAttribute("checked").equals("false");
    }

    public boolean isBoxCheckOFF() {
        return volteCheckBox.getAttribute("checked").equals("true");
    }

    public void checkBoxClick() {
        volteCheckBox.click();
    }

    public boolean isSim1Exists() {
        return sim1.getText().equals("Нет SIM-карты");
    }

    public boolean isSim2Exists() {
        return sim2.getText().equals("Нет SIM-карты");
    }

    public void sim1SettingsClick() {
        sim1Settings.click();
    }
    public void sim2SettingsClick() {
        sim2Settings.click();
    }
}