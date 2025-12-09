package test;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import pages.HomePage;

public class MultipleWindowsTest extends BaseTest{

    @Test
    public void testMultipleWindows() {
        HomePage.redirectToSection("File Upload");
        getWebDriver().switchTo().newWindow(WindowType.TAB);
        getWebDriver().get("Https://google.com");
        switchToLastOpenTab();
        getWebDriver().close();
        System.out.println("  ");
    }
}
