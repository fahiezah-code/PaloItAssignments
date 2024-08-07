package downloadTestCases;

import base.BaseTest;
import data.DownloadFileType;
import downloadPage.DownloadFilesPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import readers.CsvContentReader;
import readers.ExcelContentReader;
import readers.PdfContentReader;
import readers.ContentReader;

import java.io.File;
import java.io.IOException;

public class DataTableDownloadTest extends BaseTest {

    @Test
    public void verifyCsvDownloadContent() throws InterruptedException, IOException {
        // download the page
        DownloadFilesPage page = new DownloadFilesPage(driver)
                .load()
                .clickOnDownloadFile(DownloadFileType.CSV);

        String downloadFilePath = page.checkDownloadedFileExist();
        Assert.assertNotNull(downloadFilePath);

        ContentReader reader = new CsvContentReader();
        String actualDownloadedContent = reader.read(downloadFilePath);
        String expectedUIContent = page.readWebTableContent();

        Assert.assertEquals(actualDownloadedContent, expectedUIContent);
    }

    @Test
    public void verifyPdfDownloadContent() throws InterruptedException, IOException {
        // download the page
        DownloadFilesPage page = new DownloadFilesPage(driver)
                .load()
                .clickOnDownloadFile(DownloadFileType.PDF);

        String downloadFilePath = page.checkDownloadedFileExist();
        Assert.assertNotNull(downloadFilePath);

        ContentReader reader = new PdfContentReader();
        String actualDownloadedContent = reader.read(downloadFilePath);
        String expectedUIContent = page.readWebTableContent();

        Assert.assertEquals(actualDownloadedContent, expectedUIContent);
    }

    @Test
    public void verifyExcelDownloadContent() throws InterruptedException, IOException {
        // download the page
        DownloadFilesPage page = new DownloadFilesPage(driver)
                .load()
                .clickOnDownloadFile(DownloadFileType.EXCEL);

        String downloadFilePath = page.checkDownloadedFileExist();
        Assert.assertNotNull(downloadFilePath);

        ContentReader reader = new ExcelContentReader();
        String actualDownloadedContent = reader.read(downloadFilePath);
        String expectedUIContent = page.readWebTableContent();

        Assert.assertEquals(actualDownloadedContent, expectedUIContent);
    }

    private void deleteDownloadFolder() {
        String downloadDirectory = "DownloadFolder";
        File directory = new File(downloadDirectory);

        if (directory.exists()) {
            File[] filesList = directory.listFiles();
            if (filesList != null) {
                for (File file : filesList) {
                    file.delete();
                }
            }
        }
    }

  @AfterMethod
    @Override
    public void tearDown() {
        super.tearDown();
        deleteDownloadFolder();
    }
}
