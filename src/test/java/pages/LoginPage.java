package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigLoader;

public class LoginPage extends BasePage {
    private final By txtUsername = By.id("txt-username");
    private final By txtPassword = By.id("txt-password");
    private final By loginBtn = By.id("btn-login");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterUsernameAndPassword(){
        driver.findElement(txtUsername).sendKeys(ConfigLoader.getInstance().getUsername());
        driver.findElement(txtPassword).sendKeys(ConfigLoader.getInstance().getPassword());
        return this;
    }

    public MakeAppointmentPage clickOnLoginBtn(){
        driver.findElement(loginBtn).click();
        return new MakeAppointmentPage(driver);
    }


}
