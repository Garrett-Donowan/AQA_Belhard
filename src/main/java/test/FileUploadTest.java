package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.File;

public class FileUploadTest extends BaseTest{

    @Test
    public void testFileUpload() {
        File filePath = new File("src/main/java/resources/FileToUpload.txt");

        HomePage.redirectToSection("File Upload");
        fileUploadPage.switchToFrame();
        fileUploadPage.uploadFile(filePath.getAbsolutePath());
        Assert.assertEquals(fileUploadPage.getLastFileName(), filePath.getName());
        fileUploadPage.switchToDefaultContent();


    }
}
