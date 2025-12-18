package test;

import io.qameta.allure.Epic;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import java.util.List;

public class FileUploadTest extends BaseTest{

    @Test
    @Description("Проверка загрузки нескольких файлов на странице")
    @Epic("AUTOTEST")
    public void testFileUpload() {
        String dirPath = "src/main/resources";

        homePage.redirectToSection("File Upload");
        fileUploadPage.switchToFrame();
        List<String> actualLoadingFiles = fileUploadPage.uploadFilesGetNames(dirPath);
        List<String> expectedFileNames = fileUploadPage.expectedFileNames();
        Assert.assertEqualsNoOrder(expectedFileNames, actualLoadingFiles);
        fileUploadPage.switchToDefaultContent();
    }
}
