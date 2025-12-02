package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage{

    private static final String LINK_LOCATOR_PATTERN = "//h3/a[text()='%s']";

    public static void redirectToSection(String sectionName) {
        driver.findElement(By.xpath(String.format(LINK_LOCATOR_PATTERN, sectionName))).click();
//        driver.findElement(By.xpath(LINK_LOCATOR_PATTERN.formatted(sectionName)));
    }

    public HomePage(WebDriver driver, Actions actions){
        super(driver, actions);
    }
}
