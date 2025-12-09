package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class DynamicPage extends BasePage{

    private By cpuValue = By.xpath("//p[@class='bg-warning']");
    private By columnheaders = By.xpath("//span[@role='columnheader']");
    private By chromeRow = By.xpath("//span[text()='Chrome']/..");

    public String getCpuText(){
        return driver.findElement(cpuValue).getText();
    }

    public List<WebElement> getheader(){
        return driver.findElements(columnheaders);
    }

    public WebElement getChromeRow(){
        return driver.findElement(chromeRow);
    }


    public DynamicPage(WebDriver driver, Actions actions){
        super(driver, actions);
    }
}
