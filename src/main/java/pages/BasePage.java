package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class BasePage {

    static WebDriver driver;
    protected static Actions actions;

    public BasePage (WebDriver driver, Actions actions){
        this.driver = driver;
        this.actions = actions;
    }
}
