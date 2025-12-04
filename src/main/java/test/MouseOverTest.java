package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;



public class MouseOverTest extends BaseTest{

    @Test
    public void mouseTest() {
        HomePage.redirectToSection("Mouse Over");

        String titleBefore = mouseOverPage.getClickMeAttribute("title");
        MouseOverPage.hoverClickMeButton();
        String titleAfter = mouseOverPage.getClickMeAttribute("title");

        Assert.assertNotEquals(titleAfter, titleBefore);
        final int clickCount = 1;


        MouseOverPage.doubleClick(clickCount);
        Assert.assertTrue(Integer.valueOf(mouseOverPage.getClickCount()) == clickCount*2);

    }
}
