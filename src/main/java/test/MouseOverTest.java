package test;

import io.qameta.allure.Epic;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;



public class MouseOverTest extends BaseTest{

    @Test
    @Description("Проверка наведения указателя на элемент и проверка двойного клика")
    @Epic("AUTOTEST")
    public void mouseTest() {
        homePage.redirectToSection("Mouse Over");

        String titleBefore = mouseOverPage.getClickMeAttribute("title");
        MouseOverPage.hoverClickMeButton();
        String titleAfter = mouseOverPage.getClickMeAttribute("title");

        Assert.assertNotEquals(titleAfter, titleBefore);
        final int clickCount = 1;


        MouseOverPage.doubleClick(clickCount);
        Assert.assertTrue(Integer.valueOf(mouseOverPage.getClickCount()) == clickCount*2);

    }
}
