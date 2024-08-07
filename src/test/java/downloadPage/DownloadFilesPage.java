package downloadPage;

import base.BasePage;
import data.DownloadFileType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.List;

public class DownloadFilesPage extends BasePage {

    private static final long DEFAULT_DOWNLOAD_WAIT_TIME_IN_MILLS = 1000L;
    private static final int HEADER_ROW_INDEX = 0;
    private final By csvDownloadFileLocator = By.xpath("//span[text()='CSV']");
    private final By pdfDownloadFileLocator = By.xpath("//span[text()='PDF']");
    private final By excelDownloadFileLocator = By.xpath("//span[text()='Excel']");
    private final By webTableLocator = By.id("example");
    private final By pageCountLocator = By.xpath("//div[@id='example_paginate']//span//a");
    private final By nextPageLocator = By.id("example_next");


    public DownloadFilesPage(WebDriver driver) {
        super(driver);
    }

    public DownloadFilesPage load() {
        driver.get("https://www.lambdatest.com/selenium-playground/table-data-download-demo");
        return this;
    }

    public DownloadFilesPage clickOnDownloadFile(DownloadFileType type) throws InterruptedException {
        By locator;
        if (type == DownloadFileType.CSV) {
            locator = csvDownloadFileLocator;
        } else if (type == DownloadFileType.EXCEL) {
            locator = excelDownloadFileLocator;
        } else {
            locator = pdfDownloadFileLocator;
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
        Thread.sleep(DEFAULT_DOWNLOAD_WAIT_TIME_IN_MILLS);
        return this;
    }

    public String checkDownloadedFileExist() {
        String downloadDirectory = "DownloadFolder";
        File directory = new File(downloadDirectory);
        File[] filesList = directory.listFiles();
        if (filesList != null) {
            for (File file : filesList) {
                if (file.isFile()) {
                    return file.getAbsolutePath();
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    // Read table data from the webpage
    public String readWebTableContent() {
        StringBuilder tableData = new StringBuilder();
        WebElement table = driver.findElement(webTableLocator);
        int totalPageCount = driver.findElements(pageCountLocator).size();

        //load headers
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        WebElement headerRow = rows.get(HEADER_ROW_INDEX);
        List<WebElement> headerCols = headerRow.findElements(By.tagName("th"));
        headerCols.forEach(webElement -> tableData.append(webElement.getText()));

        //load table content
        for (int i = 0; i < totalPageCount; i++) {
            List<WebElement> trs = table.findElements(By.tagName("tr"));
            for (WebElement row : trs) {
                List<WebElement> cols = row.findElements(By.tagName("td"));
                cols.forEach(webElement -> tableData.append(webElement.getText()));
            }
            driver.findElement(nextPageLocator).click();
        }
        return tableData.toString().replaceAll("[\",\\s]", "");
    }

}
