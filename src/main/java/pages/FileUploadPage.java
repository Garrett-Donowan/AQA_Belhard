package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class FileUploadPage extends BasePage{

    private static By uploadInput = By.xpath("//input[@id='browse']");
    private static By lastInputFile = By.xpath("//div[@class='file-list__container'][last()]");

    public void uploadFile(String pathTofile){
        driver.findElement(uploadInput).sendKeys(pathTofile);
    }

    public String getLastFileName(){
        return driver.findElement(lastInputFile).getText();
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

}
