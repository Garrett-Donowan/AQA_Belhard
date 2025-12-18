package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.util.HashMap;
import java.util.Map;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class HiddenLayersPage extends BasePage {

    private static SelenideElement blueButton = $x("//button[@id='blueButton']");
    private static SelenideElement greenButton = $x("//button[@id='greenButton']");
    private static ElementsCollection buttonsDiv = $$x("//div[@class='spa-view']");


    @Step("Нажать на кнопку BlueButton")
    public void makeBlueClick() {
        blueButton.click();
    }

    @Step("Нажать на кнопку GreenButton")
    public void makeGreenCkick() {
        greenButton.click();
    }

    @Step("Получение списка кнопок и их позиций")
    public HashMap<String, String> getZOrder() {
        HashMap<String, String> buttons = new HashMap<String, String>();
        for (SelenideElement el : buttonsDiv) {
            buttons.put(el.find("Button").getAttribute("id"), el.getAttribute("style").split(" ")[1].split(";")[0]);
        }
        return buttons;
    }

    @Step("Возвращает z-index GreenButton из списка кнопок, если кнопка существует")
    public int greenButtonexists(HashMap<String, String> order) {
        int buttonOrder = -1;
            if (order.containsKey(greenButton.name())) {
                buttonOrder = Integer.parseInt(order.get(greenButton.getAttribute("id")));
            }
        return buttonOrder;
        }

    @Step("Возвращает z-index BlueButton кнопки из списка кнопок, если кнопка существует")
    public int anotherButtonExist(HashMap<String, String> order) {
        int buttonOrder = -1;
        for (Map.Entry<String, String> el : order.entrySet()) {
            if (!el.getKey().equals(greenButton.getAttribute("id"))) {
                buttonOrder = Integer.parseInt(el.getValue());
            }
        }
        return buttonOrder;
    }
}