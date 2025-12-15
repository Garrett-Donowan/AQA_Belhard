package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.DynamicIdPage;
import pages.HomePage;

public class DynamicIdTest extends BaseTest {

    @Test
    public void testPageId(){
        HomePage.redirectToSection("Dynamic ID");

        dynamicIdPage.dynamicIdButton.click();
        System.out.println("test");
    }
}
