package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CURAHomePage extends BasePage {
    private static final String HOME_ROUTE = "/";
    private final By makeAppointmentBtn = By.id("btn-make-appointment");

    public CURAHomePage(WebDriver driver) {
        super(driver);
    }

    public CURAHomePage load() {
        super.load(HOME_ROUTE);
        return this;
    }

    public LoginPage clickOnMakeAppointmentBtn() {
        driver.findElement(makeAppointmentBtn).click();
        return new LoginPage(driver);
    }
}
