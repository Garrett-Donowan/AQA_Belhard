package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class AjaxPage extends BasePage{

    private static final SelenideElement trigerButton = $x("//button[@id='ajaxButton']");
    private static final SelenideElement spinnerLoading = $x("//i[@class='fa fa-spinner fa-spin']");
    private static final ElementsCollection dataLoad = $$x("//div[@id='content']/p[@class='bg-success']");


    @Step("Нажать на кнопку Button Triggering AJAX Request")
    public void startAjaxJob() {
        trigerButton.click();
    }

    @Step("Получить элемент спиннера")
    public SelenideElement getSpinnerLoading(){
        return  spinnerLoading;
    }

    @Step("Получить список загруженных данных")
    public ElementsCollection getDataLoad(){
        return dataLoad;
    }
}
