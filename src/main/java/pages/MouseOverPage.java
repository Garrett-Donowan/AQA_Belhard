package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class MouseOverPage extends BasePage{

    private static SelenideElement clickMeButton = $x("//a[text()='Click me']");
//    private static SelenideElement clickMeCounter = $x("//a[text()='Link Button'");
    private static SelenideElement clickCounterunter = $x("//span[@id='clickCount']");

    public static void hoverClickMeButton() {
        clickMeButton.hover();
    }

    public String getClickCount() {
        return clickCounterunter.getText();
    }

    public static void doubleClick(int clickCount){
        for(int i = 0; i < clickCount; i++) {
            clickMeButton.doubleClick();
        }
    }

    public String  getClickMeAttribute(String attributeName) {
        return clickMeButton.getAttribute(attributeName);
    }
}
