package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class AlertPage extends BasePage{

    private static SelenideElement promptButton = $x("//button[@id='promptButton']");
    private static SelenideElement confirmButton = $x("//button[@id='confirmButton']");

    public void clickPromptButton(){
        promptButton.click();
    }
    public void clickConfirmButton(){
        confirmButton.click();
    }

    public void confirmAlert(){
        Selenide.switchTo().alert().accept();
    }

    public void dismissAlert(){
        Selenide.switchTo().alert().dismiss();
    }

    public String getTextAlert(){
        return Selenide.switchTo().alert().getText();
    }

    public void setTextAlert(String text){
        Selenide.switchTo().alert().sendKeys(text);
    }


}
