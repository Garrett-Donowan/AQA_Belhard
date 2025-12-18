package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class TextInputPage extends BasePage{

    private static SelenideElement textButton = $x("//button[@id='updatingButton']");
    private static SelenideElement inputField = $x("//*[@id='newButtonName']");

    @Step("Получить текстовое значение с кнопки")
    public String  getButtonText() {
        return textButton.getText();
    }

    @Step("Ввести данные в поле ввода значений")
    public void  sendData(String data) {
        inputField.sendKeys(data);
    }

    @Step("Нажать кнопку")
    public void clickButton(){
        textButton.click();
    }

    @Step("Очистить поле ввода значений")
    public void clearField(){
        inputField.clear();
    }
}
