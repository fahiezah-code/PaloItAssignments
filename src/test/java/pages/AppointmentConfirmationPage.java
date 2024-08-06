package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AppointmentConfirmationPage extends BasePage {
    private final By successBooking = By.xpath("//p[@class='lead']");
    private final By menu = By.id("menu-toggle");
    private final By historyMenu = By.linkText("History");

    public AppointmentConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayedSuccessMessage() {
        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(successBooking));
        return ele.isDisplayed();
    }

    public AppointmentConfirmationPage clickOnMenu() {
        driver.findElement(menu).click();
        return this;
    }

    public HistoryPage clickOnHistory() {
        driver.findElement(historyMenu).click();
        return new HistoryPage(driver);
    }
}
