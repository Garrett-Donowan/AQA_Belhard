package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FileUploadPage extends BasePage{

    private static By uploadInput = By.xpath("//input[@id='browse']");
    private static By lastInputFiles = By.xpath("//div[@class='file-list__container']");

    public List<String> expectedFileNames(){
        List<String> expectedFileNames = new ArrayList<>();
        try {
            for (String el: driver.findElement(lastInputFiles).getText().split("\n")){
                expectedFileNames.add(el);
            }
            return expectedFileNames;
        } catch (NoSuchElementException e){
            System.out.println("Файлы не были загружены");
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

    public List<String> uploadFilesGetNames(String dirPath){
        List<String> allowedExtensions = new ArrayList<>(Arrays.asList("PDF", "DOCX", "PPTX", "TXT", "XLSX"));
        File dir = new File(dirPath);
        List<String> uploadingFileNames = new ArrayList<>();
        List<String> filePaths = new ArrayList<>();
        for (File file: Objects.requireNonNull(dir.listFiles())){
            if ((file.isFile()) && (allowedExtensions.contains(file.getName().split("\\.")[1].toUpperCase()))){
                uploadingFileNames.add(file.getName());
                filePaths.add(file.getAbsolutePath());
            }
        }
        try {
            String combinedInput = String.join("\n", filePaths);
            driver.findElement(uploadInput).sendKeys(combinedInput);
            return uploadingFileNames;
        } catch (InvalidArgumentException e) {
            System.out.println("Отсутствуют файлы для загрузки в директории " + dirPath);
            return uploadingFileNames;
        }
    }
}
