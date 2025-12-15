package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class AlertPage extends BasePage{

    private static SelenideElement promptButton = $x("//button[@id='promptButton']");
    private static SelenideElement confirmButton = $x("//button[@id='confirmButton']");


    public void clickPromptButton(){
        promptButton.click();
    }

    @Step("Нажать кнопку Confirm")
    public void clickConfirmButton(){
        confirmButton.click();
    }

    @Step("нажать подтвердить alert")
    public void confirmAlert(){
        Selenide.switchTo().alert().accept();
    }

    public void dismissAlert(){
        Selenide.switchTo().alert().dismiss();
    }

    @Step("Получить текст Alert")
    public String getTextAlert(){
        return Selenide.switchTo().alert().getText();
    }

    @Step("ВВести текст в поле ввода alert")
    public void setTextAlert(String text){
        Selenide.switchTo().alert().sendKeys(text);
    }


}
