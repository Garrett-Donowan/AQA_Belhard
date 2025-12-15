package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import java.util.List;

public class FileUploadTest extends BaseTest{

    @Test
    public void testFileUpload() {
        String dirPath = "src\\main\\java\\resources";

        HomePage.redirectToSection("File Upload");
        fileUploadPage.switchToFrame();
        List<String> actualLoadingFiles = fileUploadPage.uploadFilesGetNames(dirPath);
        List<String> expectedFileNames = fileUploadPage.expectedFileNames();
        Assert.assertEqualsNoOrder(expectedFileNames, actualLoadingFiles);
        fileUploadPage.switchToDefaultContent();
    }
}
