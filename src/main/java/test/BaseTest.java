package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import pages.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public abstract class BaseTest {

    protected HomePage homePage = new HomePage(getWebDriver(), getActions());
    protected MouseOverPage mouseOverPage = new MouseOverPage(getWebDriver(), getActions());
    protected Properties runProperties;
    protected AlertPage alertPage = new AlertPage(getWebDriver(), getActions());
    protected TextInputPage textInputPage = new TextInputPage(getWebDriver(), getActions());
    protected FileUploadPage fileUploadPage = new FileUploadPage(getWebDriver(), getActions());
    protected DynamicPage dynamicPage = new DynamicPage(getWebDriver(), getActions());



//    private static WebDriver driver;
//    private static Actions actions;
//
//    @AfterSuite(alwaysRun = true)
//    public void closeBrowser(){
//        driver.quit();
//        driver = null;
//    }
//
    @BeforeClass
    public void openBasePage(){
        try {
            setProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Selenide.open(runProperties.getProperty("baseURL"));
    }
//
//
//    public static WebDriver getWebDriver() {
//        if (driver == null) {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//            return driver;
//        } else {
//            return driver;
//        }
//    }
//
//    public static Actions getActions() {
//        if (actions == null) {
//            return new Actions(getWebDriver());
//        } else {
//            return actions;
//
//        }
//    }

    @BeforeTest
    public void setProperties() throws IOException {
        runProperties = new Properties();
        FileInputStream fls = new FileInputStream("src/main/java/resources/properties.properties");
        runProperties.load(fls);
        fls.close();
    }

    public void switchToLastOpenTab(){
        List<String> openedWindows = driver.getWindowHandles().stream().toList();
        driver.switchTo().window(openedWindows.get(openedWindows.size()-1));
    }
}

