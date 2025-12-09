package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.File;
import java.util.List;

public class FileUploadTest extends BaseTest{

    @Test
    public void testFileUpload() {
        String dirPath = "D:\\Work\\GitHub\\QA_Belhard\\AQA_Belhard\\src\\main\\java\\resources";

        HomePage.redirectToSection("File Upload");
        fileUploadPage.switchToFrame();
        List<String> actualLoadingFiles = fileUploadPage.uploadFileNames(dirPath);
        Assert.assertEqualsNoOrder(fileUploadPage.expectedFileNames(), actualLoadingFiles);
        fileUploadPage.switchToDefaultContent();

    }
}
