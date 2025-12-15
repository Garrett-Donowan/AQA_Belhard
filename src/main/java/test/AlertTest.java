package test;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import java.time.LocalDate;
import java.util.*;

public class AlertTest extends BaseTest{

    @Test
    public void testAlert(){
        Selenide.open(runProperties.getProperty("BaseUrl"));
        final String data = "dogs";
        String expectedData = "User value: %s".formatted(data);
        final LocalDate today = LocalDate.now();
        String flag;

        HomePage.redirectToSection("Alerts");
        alertPage.clickPromptButton();
        alertPage.setTextAlert(data);
        alertPage.confirmAlert();
        Selenide.sleep(6000);
        Selenide.Wait().until(ExpectedConditions.alertIsPresent());
        String actualData = alertPage.getTextAlert();
        alertPage.confirmAlert();
        Assert.assertEquals(actualData, expectedData);

        alertPage.clickConfirmButton();
        String alertInfoStr = alertPage.getTextAlert().toUpperCase();
        if (alertInfoStr.contains(today.getDayOfWeek().toString())) {
            flag = "Yes";
            alertPage.confirmAlert();
        } else {
            flag = "No";
            alertPage.dismissAlert();
        }

        Selenide.Wait().until(ExpectedConditions.alertIsPresent());
        String actualAlert = alertPage.getTextAlert();
        alertPage.confirmAlert();
        Assert.assertEquals(actualAlert, flag);
    }
}
//alerts сделать логику Confirm и нажать да или нет, в зависимости от условия (пятница или нет).
//textInput 2 итерации
