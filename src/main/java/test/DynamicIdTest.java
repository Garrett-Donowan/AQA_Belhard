package test;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicIdTest extends BaseTest {

    @Test
    @Description("Проверка обработки элементов с динамическим ID")
    @Epic("AUTOTEST")
    public void testPageId(){

        homePage.redirectToSection("Dynamic ID");
        String initialID = dynamicIdPage.getID();
        dynamicIdPage.makeClick();
        Selenide.refresh();
        String changedId = dynamicIdPage.getID();
        Assert.assertNotEquals(changedId, initialID);
    }
}
