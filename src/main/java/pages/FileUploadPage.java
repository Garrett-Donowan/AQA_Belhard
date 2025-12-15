package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.InvalidArgumentException;
import java.io.File;
import java.util.*;
import static com.codeborne.selenide.Selenide.$x;

public class FileUploadPage extends BasePage{

    private static  SelenideElement uploadInput = $x("//input[@id='browse']");
    private static  SelenideElement lastInputFiles = $x("//div[@class='file-list__container']");

    public List<String> expectedFileNames(){
        List<String> expectedFileNames = new ArrayList<>();
        try {
            for (String el: lastInputFiles.getText().split("\n")){
                expectedFileNames.add(el);
            }
            return expectedFileNames;
        } catch (NoSuchElementException e){
            System.out.println("Файлы не были загружены");
        }
        return expectedFileNames;
    }

    public void switchToFrame(){
        Selenide.switchTo().frame(0);
    }

    public void switchToDefaultContent(){
        Selenide.switchTo().defaultContent();
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
            uploadInput.sendKeys(combinedInput);
            return uploadingFileNames;
        } catch (InvalidArgumentException e) {
            System.out.println("Отсутствуют файлы для загрузки в директории " + dirPath);
            return uploadingFileNames;
        }
    }
}
