package test;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;


public class DynamicPageTest extends BaseTest{

    @Test
    public void testDynamicPage() {
        HomePage.redirectToSection("Dynamic Table");

        String expectedValue = dynamicPage.getCpuText();

        ElementsCollection actualHeaders = dynamicPage.getheader();

        int cpu = 0;
        for (int i = 0; i < actualHeaders.size(); i++) {
            String header = actualHeaders.get(i).getText();
            if (header.equals("CPU")) {
                cpu = i;
                break;
            }
        }

        String tableValue = dynamicPage.getChromeRow()
                .findElements(By.xpath("./span"))
                .get(cpu)
                .getText();
        Assert.assertEquals(expectedValue.split(" ")[2], tableValue);


    }
}
