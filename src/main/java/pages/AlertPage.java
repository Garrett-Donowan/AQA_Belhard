package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AlertPage extends BasePage{

    private static By promptButton = By.xpath("//button[@id='promptButton']");
    private static By confirmButton = By.xpath("//button[@id='confirmButton']");

    public void clickPromptButton(){
        driver.findElement(promptButton).click();
    }

    public void clickConfirmButton(){
        driver.findElement(confirmButton).click();
    }

    public void confirmAlert(){
        driver.switchTo().alert().accept();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public String getTextAlert(){
        return driver.switchTo().alert().getText();
    }

    public void setTextAlert(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    public AlertPage(WebDriver driver, Actions actions) {
        super(driver, actions);
    }

}
