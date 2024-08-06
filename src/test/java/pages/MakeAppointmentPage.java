package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MakeAppointmentPage extends BasePage {
    private final By facilityField = By.id("combo_facility");
    private String program;

    private final By hospitalReadmission = By.id("chk_hospotal_readmission");
    private final By medicareProgram = By.id("//input[@value='"+program+"']");
    private final By calendar = By.id("txt_visit_date");

    //selectDate should be dynamic
  //  private final By selectDate = By.xpath("(//td[normalize-space()='20'])[1]");
    private final By addComment = By.id("txt_comment");
    private final By bookAppointmentBtn = By.id("btn-book-appointment");

    public MakeAppointmentPage(WebDriver driver) {
        super(driver);
    }

    public MakeAppointmentPage selectFacility(String facility){
        WebElement ele = driver.findElement(facilityField);
        ele.click();
        Select select = new Select(ele);
        select.selectByValue(facility);

        return this;
    }

    public MakeAppointmentPage selectForApplyHospitalReadmission(boolean isSelected){
        if(isSelected){
            driver.findElement(hospitalReadmission).click(); //need to check whether it is selected aldy
        }
        return this;
    }
    public MakeAppointmentPage selectMedicareProgram(int program){
        List<WebElement> programs = driver.findElements(By.name("programs"));
        programs.get(program).click();
        return this;
    }
    public MakeAppointmentPage selectAppointmentDate(String date){
        driver.findElement(calendar).sendKeys(date);
        return this;
    }
    public MakeAppointmentPage enterComment(String comment){
        driver.findElement(addComment).sendKeys(comment);
        return this;

    }
    public AppointmentConfirmationPage clickOnBookAppointmentBtn(){
        driver.findElement(bookAppointmentBtn).click();
        return new AppointmentConfirmationPage(driver);
    }
}
