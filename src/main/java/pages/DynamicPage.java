package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class DynamicPage extends BasePage{

    private static SelenideElement cpuValue = $x("//p[@class='bg-warning']");
    private static ElementsCollection columnheaders = $$x("//span[@role='columnheader']");
    private static SelenideElement chromeRow = $x("//span[text()='Chrome']/..");

    public String getCpuText(){
        return cpuValue.getText();
    }

    public ElementsCollection getheader(){
        return columnheaders;
    }

    public SelenideElement getChromeRow(){
        return chromeRow;
    }

}
