package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;


public class DynamicIdPage extends BasePage{

    public static SelenideElement dynamicIdButton = $x("//button[@class='btn btn-primary']");

    @Step("Сделать клик по кнопке")
    public void makeClick(){
        dynamicIdButton.click();
    }

    @Step("Получить ID кнопки")
    public String getID(){
        return dynamicIdButton.getAttribute("id");
    }
}
