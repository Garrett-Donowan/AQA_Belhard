package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class DynamicPage extends BasePage{

    private static SelenideElement cpuValue = $x("//p[@class='bg-warning']");
    private static ElementsCollection columnheaders = $$x("//span[@role='columnheader']");
    private static SelenideElement chromeRow = $x("//span[text()='Chrome']/..");

    @Step("Получить текстовое значение CpuValue Chrome")
    public String getCpuText(){
        return cpuValue.getText();
    }

    @Step("Получить элементы заголовков таблицы")
    public ElementsCollection getheader(){
        return columnheaders;
    }

    @Step("Получить строку значений для поля Chrome")
    public SelenideElement getChromeRow(){
        return chromeRow;
    }

}
