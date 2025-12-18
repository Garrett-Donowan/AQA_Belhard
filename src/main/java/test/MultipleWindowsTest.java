package test;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import jdk.jfr.Description;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

public class MultipleWindowsTest extends BaseTest{

    @Test
    @Description("Проверка обработки нескольких вкладок в окне браузера")
    @Epic("AUTOTEST")
    public void testMultipleWindows() {

        homePage.redirectToSection("File Upload");
        Selenide.switchTo().newWindow(WindowType.TAB);
        Selenide.open("Https://google.com");
        Selenide.switchTo().newWindow(WindowType.TAB);
        Selenide.open("Https://ya.ru");
        Selenide.switchTo().window(0);
        switchToLastOpenTab();
        Selenide.closeWindow();
    }
}
