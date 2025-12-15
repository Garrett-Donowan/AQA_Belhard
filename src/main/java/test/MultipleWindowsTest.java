package test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import pages.HomePage;

public class MultipleWindowsTest extends BaseTest{

    WebDriver driver = WebDriverRunner.getWebDriver();

    @Test
    public void testMultipleWindows() {
        String playHandles = driver.getWindowHandle();

        HomePage.redirectToSection("File Upload");
        Selenide.switchTo().newWindow(WindowType.TAB);
        Selenide.open("Https://google.com");
        switchToLastOpenTab();
        Selenide.closeWindow();
        System.out.println("test");
    }
}
