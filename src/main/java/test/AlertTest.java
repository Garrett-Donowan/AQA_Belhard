package test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;
import java.time.LocalDate;
import java.util.*;

public class AlertTest extends BaseTest{

    @Test
    public void testAlert(){

        final String data = "dogs";
        String expectedData = "User value: %s".formatted(data);
        final LocalDate today = LocalDate.now();
        String flag;

        HomePage.redirectToSection("Alerts");
        alertPage.clickPromptButton();
        alertPage.setTextAlert(data);
        alertPage.confirmAlert();
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(6));
        wait.until(ExpectedConditions.alertIsPresent());
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

        wait.until(ExpectedConditions.alertIsPresent());
        String actualAlert = alertPage.getTextAlert();
        alertPage.confirmAlert();
        Assert.assertEquals(actualAlert, flag);
    }
}
//alerts сделать логику Confirm и нажать да или нет, в зависимости от условия (пятница или нет).
//textInput 2 итерации
