package test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import pages.HomePage;

public class MultipleWindowsTest extends BaseTest{

    @Test
    public void testMultipleWindows() {

        HomePage.redirectToSection("File Upload");
        Selenide.switchTo().newWindow(WindowType.TAB);
        Selenide.open("Https://google.com");
        switchToLastOpenTab();
        Selenide.closeWindow();
        System.out.println("test");
    }
}
