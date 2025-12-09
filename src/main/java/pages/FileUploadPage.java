package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FileUploadPage extends BasePage{

    private static By uploadInput = By.xpath("//input[@id='browse']");
    private static By lastInputFiles = By.xpath("//div[@class='file-list__container']");
    private List<String> expectedFileNames = new ArrayList<>();

    public List<String> expectedFileNames(){
        for (String el: driver.findElement(lastInputFiles).getText().split("\n")){
            expectedFileNames.add(el);
        }
        return expectedFileNames;
    }

    public void switchToFrame(){
        driver.switchTo().frame(0);
    }

    public void switchToDefaultContent(){
        driver.switchTo().defaultContent();
    }

    public FileUploadPage(WebDriver driver, Actions actions){
        super(driver, actions);
    }

    public List<String> uploadFileNames(String dirPath){
        File dir = new File(dirPath);
        List<String> uploadingFileNames = new ArrayList<>();
        List<String> filePaths = new ArrayList<>();
        for (File file: Objects.requireNonNull(dir.listFiles())){
            if ((file.isFile()) && (!file.getName().split("\\.")[1].equals("properties"))){
                uploadingFileNames.add(file.getName());
                filePaths.add(file.getAbsolutePath());
            }
        }
        String combinedInput = String.join("\n", filePaths);
        driver.findElement(uploadInput).sendKeys(combinedInput);
        return uploadingFileNames;
    }



}
