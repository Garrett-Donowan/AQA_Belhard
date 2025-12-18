package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class MouseOverPage extends BasePage{

    private static SelenideElement clickMeButton = $x("//a[text()='Click me']");
    private static SelenideElement clickCounterunter = $x("//span[@id='clickCount']");

    @Step("Навести указатель на ссылку ClickMe")
    public static void hoverClickMeButton() {
        clickMeButton.hover();
    }

    @Step("Получить значение счетчика кликов ClickMe со страницы")
    public String getClickCount() {
        return clickCounterunter.getText();
    }

    @Step("Сделать двойной клик по ссылке ClickMe")
    public static void doubleClick(int clickCount){
        for(int i = 0; i < clickCount; i++) {
            clickMeButton.doubleClick();
        }
    }

    @Step("Получить атрибут {attributeName} ссылки ClickMe")
    public String  getClickMeAttribute(String attributeName) {
        return clickMeButton.getAttribute(attributeName);
    }
}
