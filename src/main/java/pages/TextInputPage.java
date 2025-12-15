package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class TextInputPage extends BasePage{

    private static SelenideElement textButton = $x("//button[@id='updatingButton']");
    private static SelenideElement inputField = $x("//*[@id='newButtonName']");

    public TextInputPage() {

    }

    public String  getButtonText() {
        return textButton.getText();
    }

    public void  sendData(String data) {
        inputField.sendKeys(data);
    }

    public void clickButton(){
        textButton.click();
    }

    public void clearField(){
        inputField.clear();
    }
}
