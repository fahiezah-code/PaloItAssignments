package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager implements DriverManager{

    @Override
    public WebDriver createDriver() {
        WebDriverManager.firefoxdriver().cachePath("Drivers").setup();

        String projectDir = System.getProperty("user.dir");
        String downloadDir =projectDir+"/DownloadFolder";

        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("browser.download.dir", downloadDir);
        options.addPreference("browser.download.folderList", 2);
        options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream"); // Adjust MIME type as needed
        options.addPreference("pdfjs.disabled", true); // Disable PDF viewer if downloading PDFs
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        return driver;
    }
}
