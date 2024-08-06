package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager implements DriverManager {
    public static final String DRIVER_FOLDER_NAME = "Drivers";

    @Override
    public WebDriver createDriver() {

        WebDriverManager.chromedriver().cachePath(DRIVER_FOLDER_NAME).setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
