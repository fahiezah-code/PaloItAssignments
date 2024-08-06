package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HistoryPage extends BasePage {

    private final By appointmentDate = By.className("panel-heading");
    private final By facilitySelect = By.id("facility");
    private final By applyReadmission = By.id("hospital_readmission");
    private final By program = By.id("program");
    private final By comment = By.id("comment");

    public String getConfirmDate(){
        return driver.findElement(appointmentDate).getText();
    }
    public String getFacilityValue(){
        return driver.findElement(facilitySelect).getText();
    }

    public String getApplyReadmission() {
        return driver.findElement(applyReadmission).getText();
    }

    public String getAppointmentDate() {
        return driver.findElement(appointmentDate).getText();
    }

    public String getComment() {
        return driver.findElement(comment).getText();
    }
    public String getProgram() {
        return driver.findElement(program).getText();
    }


    public HistoryPage(WebDriver driver) {
        super(driver);
    }
}
