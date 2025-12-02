package test;

import org.testng.annotations.Test;
import pages.*;
import java.io.IOException;


public class MouseOverTest extends BaseTest{

    @Test
    public void mouseTest() throws IOException {
        getWebDriver().get(getProperties("baseURL"));
        HomePage.redirectToSection("Mouse Over");
        MouseOverPage.hoverClickMeButton();
        MouseOverPage.doubleClick(1);

    }
}
