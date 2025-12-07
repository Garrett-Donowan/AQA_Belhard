package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class TextInputPage extends BasePage{

    private static By textButton = By.xpath("//button[@id='updatingButton']");
    private static By inputField = By.xpath("//*[@id='newButtonName']");

    public String  getButtonText() {
        return driver.findElement(textButton).getText();
    }

    public void  sendData(String data) {
        driver.findElement(inputField).sendKeys(data);
    }

    public void clickButton(){
        driver.findElement(textButton).click();
    }

    public void clearField(){
        driver.findElement(inputField).clear();
    }

    public TextInputPage(WebDriver driver, Actions actions){
        super(driver, actions);
    }
}
