package pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$x;


public class DynamicIdPage extends BasePage{

    public SelenideElement dynamicIdButton = $x("//button[@class='btn btn-primary']");

}
