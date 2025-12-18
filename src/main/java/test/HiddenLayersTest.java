package test;

import io.qameta.allure.Epic;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;


public class HiddenLayersTest extends BaseTest{


    @Test
    @Description("Проверка доступности элементов на странице")
    @Epic("AUTOTEST")
    public void testHiddenLayers(){

        homePage.redirectToSection("Hidden Layers");
        HashMap<String, String> initialOrder = hiddenLayersPage.getZOrder();
        hiddenLayersPage.makeGreenCkick();
        HashMap<String, String> updatedOrder = hiddenLayersPage.getZOrder();
        try {
            hiddenLayersPage.makeGreenCkick();
        } catch (Throwable  e) {
            System.out.println(e.getMessage());
            Assert.assertTrue(e.getMessage().contains("ElementClickInterceptedException"));
        }
        hiddenLayersPage.makeBlueClick();
        int greenButtonOrder = hiddenLayersPage.greenButtonexists(initialOrder);
        int blueButtonOrder = hiddenLayersPage.anotherButtonExist(updatedOrder);
        Assert.assertTrue(blueButtonOrder>greenButtonOrder);
        }
}

