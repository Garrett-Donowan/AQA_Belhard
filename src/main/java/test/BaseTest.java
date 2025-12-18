package test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
//import listeners.TestListener;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.testng.annotations.*;
import pages.*;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

//@Listeners(TestListener.class)
public abstract class BaseTest {
    protected Properties runProperties;

    protected HomePage homePage = new HomePage();
    protected MouseOverPage mouseOverPage = new MouseOverPage();
    protected AlertPage alertPage = new AlertPage();
    protected TextInputPage textInputPage = new TextInputPage();
    protected FileUploadPage fileUploadPage = new FileUploadPage();
    protected DynamicPage dynamicPage = new DynamicPage();
    protected DynamicIdPage dynamicIdPage = new DynamicIdPage();
    protected AjaxPage ajaxPage = new AjaxPage();
    protected HiddenLayersPage hiddenLayersPage = new HiddenLayersPage();

    @BeforeClass
    @Step("Открыть страницу BasePage")
    public void openBasePage(){
        try {
            setProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Selenide.open(runProperties.getProperty("baseURL"));
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @BeforeTest
    @Step("Получить адрес страницы BasePage")
    public void setProperties() throws IOException {
        runProperties = new Properties();
        FileInputStream fls = new FileInputStream("src/main/resources/properties.properties");
        runProperties.load(fls);
        fls.close();
    }

    @Step("Переключиться на последнюю открытую вкладку")
    public void switchToLastOpenTab(){
        List<String> openedWindows = getWebDriver().getWindowHandles().stream().toList();
        Selenide.switchTo().window(openedWindows.get(openedWindows.size()-1));
    }

    @Step("Сделать скриншот страницы")
    public static void getScreenshotes(){
        byte[] bytes = Selenide.screenshot(OutputType.BYTES);
        if (bytes != null){
            Allure.addAttachment("Screen", "image/png", new ByteArrayInputStream(bytes), "png");
        } else {
            System.out.println("не удалось сделать скриншот");
        }
   }

}

