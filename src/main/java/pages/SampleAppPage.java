package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$x;

public class SampleAppPage extends BasePage{
    private static SelenideElement userNameField = $x("//input[@name='UserName']");
    private static SelenideElement passwordField = $x("//input[@name='Password']");
    private static SelenideElement buttonLogIn = $x("//button[@class='btn btn-primary']");
    private static SelenideElement loginStatus = $x("//label[@id='loginstatus']");

    @Step("Ввод значений в поля ввода логина/пароля")
    public void enterLoginPwd(String k, String v){
        userNameField.sendKeys(k);
        passwordField.sendKeys(v);
    }

    @Step("Нажатие на кнопку Log In (Log Out)")
    public void clickLogInButton(){
        buttonLogIn.click();
    }

    @Step("Получение статуса логина и цвета строки с введенной парой логин/пароль")
    public String[] loginStatus(){
        return new String[] {loginStatus.getText(), loginStatus.getCssValue("color")};
    }
}
