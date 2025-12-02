package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import pages.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class BaseTest {

    protected HomePage homePage = new HomePage(getWebDriver(), getActions());
    protected MouseOverPage mouseOverPage = new MouseOverPage(getWebDriver(), getActions());

    private static WebDriver driver;
    private static Actions actions;

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    public static WebDriver getWebDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            return driver = new ChromeDriver();
        } else {
            return driver;
        }
    }

    public static Actions getActions() {
        if (actions == null) {
            return new Actions(getWebDriver());
        } else {
            return actions;

        }
    }

    public String getProperties(String propertyKey) throws IOException {
        Properties properties = new Properties();
        FileInputStream fls = new FileInputStream("src/main/java/resources/properties.properties");
        properties.load(fls);
        fls.close();
        return properties.getProperty(propertyKey);
    }
}

