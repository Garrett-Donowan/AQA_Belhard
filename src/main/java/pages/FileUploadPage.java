package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.InvalidArgumentException;
import java.io.File;
import java.util.*;
import static com.codeborne.selenide.Selenide.$x;

public class FileUploadPage extends BasePage{

    private static  SelenideElement uploadInput = $x("//input[@id='browse']");
    private static  SelenideElement lastInputFiles = $x("//div[@class='file-list__container']");

    @Step("Получить список загруженных файлов со страницы")
    public List<String> expectedFileNames(){
        List<String> expectedFileNames = new ArrayList<>();
        try {
            for (String el: lastInputFiles.getText().split("\n")){
                expectedFileNames.add(el);
            }
            return expectedFileNames;
        } catch (NoSuchElementException e){
            System.out.println("Файлы не были загружены");
            e.printStackTrace();
        }
        return expectedFileNames;
    }

    @Step("Переключиться на фрейм загрузки файлов")
    public void switchToFrame(){
        Selenide.switchTo().frame(0);
    }

    @Step("Переключиться на основной фрейм страницы")
    public void switchToDefaultContent(){
        Selenide.switchTo().defaultContent();
    }

    @Step("Загрузить файлы из директории {dirPath} на страницу, получить список загружаемых файлов из директории")
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
            e.printStackTrace();
            return uploadingFileNames;
        }
    }
}
