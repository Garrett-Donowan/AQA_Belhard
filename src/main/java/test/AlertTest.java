package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertPage;
import pages.HomePage;

import java.time.Duration;
import java.util.Calendar;

public class AlertTest extends BaseTest{

    @Test
    public void testAlert(){

        final String data = "dogs";
        String expectedData = "User value: %s".formatted(data);


        HomePage.redirectToSection("Alerts");
        alertPage.clickPromptButton();
        alertPage.setTextAlert(data);
        alertPage.confirmAlert();
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(6));
        wait.until(ExpectedConditions.alertIsPresent());
        String actualData = alertPage.getTextAlert();
        alertPage.confirmAlert();
        Assert.assertEquals(actualData, expectedData);

        System.out.println(Calendar.getInstance().getTime());

    }
}
//alerts сделать логику Confirm и нажать да или нет, в зависимости от условия (пятница или нет).
//textInput 2 итерации
