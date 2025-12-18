package test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Epic;
import jdk.jfr.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;


public class AjaxTest extends BaseTest{

    private static final String expectedText = "Data loaded with AJAX get request.";

    @Test
    @Description("Проверка обработки Ajax запросов")
    @Epic("AUTOTEST")
    public void testAjax(){

        homePage.redirectToSection("AJAX Data");

        for (int i = 0; i < 2; i++) {
            ajaxPage.startAjaxJob();
            Selenide
                    .Wait().withTimeout(Duration.ofSeconds(20))
                    .until(ExpectedConditions.invisibilityOf(ajaxPage.getSpinnerLoading()));
        }

        List<SelenideElement> data = ajaxPage.getDataLoad().stream().toList();
        Assert.assertNotNull(data);

        if (!data.isEmpty()){
            for (SelenideElement el : data) {
                Assert.assertEquals(el.getText(), expectedText);
            }
        }
    }
}
