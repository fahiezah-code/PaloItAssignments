package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ChromeDriverManager implements DriverManager {
    public static final String DRIVER_FOLDER_NAME = "Drivers";

    @Override
    public WebDriver createDriver() {

        WebDriverManager.chromedriver().cachePath(DRIVER_FOLDER_NAME).setup();
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", Paths.get("DownloadFolder").toAbsolutePath().toString());
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }
}
