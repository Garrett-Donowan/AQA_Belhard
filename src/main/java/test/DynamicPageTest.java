package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.List;

public class DynamicPageTest extends BaseTest{

    @Test
    public void testDynamicPage() {
        HomePage.redirectToSection("Dynamic Table");

        String expetedValue = dynamicPage.getCpuText();

        List<WebElement> actualHeaders = dynamicPage.getheader();

        int cpu = 0;
        for (WebElement el : actualHeaders) {
            if (el.getText().equals("CPU")) {
                cpu = actualHeaders.indexOf(el);
            }
        }

        String tableValue = dynamicPage.getChromeRow().findElements(By.xpath("./span")).get(cpu).getText();
        Assert.assertEquals(expetedValue.split(" ")[2], tableValue);


    }
}
