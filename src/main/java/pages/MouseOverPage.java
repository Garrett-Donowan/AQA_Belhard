package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOverPage extends BasePage{

    private static By clickMeButton = By.xpath("//a[text()='Click me']");
    // private By clickMeCounter = By.xpath("//a[text()='Link Button'");
    private By clickCounterunter = By.xpath("//span[@id='clickCount']");

    public static void hoverClickMeButton() {
        actions.moveToElement(driver.findElement(clickMeButton)).perform();
    }

    public String getClickCount() {
        return driver.findElement(clickCounterunter).getText();
    }

    public static void doubleClick(int clickCount){
        for(int i = 0; i < clickCount; i++) {
            actions.doubleClick(driver.findElement(clickMeButton));
        }
    }

    public String getClickMeAttribute(String attruibuteName) {
        return driver.findElement(clickMeButton).getAttribute(attruibuteName);
    }

    public MouseOverPage(WebDriver driver, Actions actions){
        super(driver, actions);
    }
}
