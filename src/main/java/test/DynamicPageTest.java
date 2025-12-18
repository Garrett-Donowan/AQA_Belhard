package test;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Epic;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DynamicPageTest extends BaseTest{

    @Test
    @Description("Проверка обработки элементов с динамическим расположением на странице")
    @Epic("AUTOTEST")
    public void testDynamicPage() {
        homePage.redirectToSection("Dynamic Table");

        final String expectedValue = dynamicPage.getCpuText();

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
