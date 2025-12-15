package test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.*;
import pages.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public abstract class BaseTest {

    protected Properties runProperties;
    protected HomePage homePage = new HomePage();
    protected MouseOverPage mouseOverPage = new MouseOverPage();
    protected AlertPage alertPage = new AlertPage();
    protected TextInputPage textInputPage = new TextInputPage();
    protected FileUploadPage fileUploadPage = new FileUploadPage();
    protected DynamicPage dynamicPage = new DynamicPage();
    protected DynamicIdPage dynamicIdPage = new DynamicIdPage();



//    private static WebDriver driver;
//    private static Actions actions;
//
//    @AfterSuite(alwaysRun = true)
//    public void closeBrowser(){
//        driver.quit();
//        driver = null;
//    }
//
//    @BeforeClass
//    public void openBasePage(){
//        try {
//            setProperties();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        getWebDriver().get(runProperties.getProperty("baseURL"));
//    }
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
        List<String> openedWindows = WebDriverRunner.getWebDriver().getWindowHandles().stream().toList();
        Selenide.switchTo().window(openedWindows.get(openedWindows.size()-1));
    }
}

