package base;

import constant.DriverType;
import factory.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setUpDriver(String browser){

      driver =  DriverManagerFactory.getDriver(DriverType.valueOf(browser)).createDriver();
    }

   @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
