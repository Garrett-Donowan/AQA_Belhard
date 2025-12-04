package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pages.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class BaseTest {

    protected HomePage homePage = new HomePage(getWebDriver(), getActions());
    protected MouseOverPage mouseOverPage = new MouseOverPage(getWebDriver(), getActions());
    protected Properties runProperties;
    protected AlertPage alertPage = new AlertPage(getWebDriver(), getActions());

    private static WebDriver driver;
    private static Actions actions;

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    @BeforeClass
    public void openBasePage(){
        getWebDriver().get(runProperties.getProperty("baseURL"));
    }

    public static WebDriver getWebDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            return driver;

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

    @BeforeSuite
    public void setProperties() throws IOException {
        runProperties = new Properties();
        FileInputStream fls = new FileInputStream("src/main/java/resources/properties.properties");
        runProperties.load(fls);
        fls.close();
    }
}

