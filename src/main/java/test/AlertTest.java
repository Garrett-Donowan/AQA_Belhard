package test;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import jdk.jfr.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.time.LocalDate;
import java.util.*;

public class AlertTest extends BaseTest{

    @Test
    @Description("Проверка обработки Алертов")
    @Epic("AUTOTEST")
    public void testAlert(){
        final String data = "dogs";
        String expectedData = "User value: %s".formatted(data);
        final LocalDate today = LocalDate.now();
        String flag;

        homePage.redirectToSection("Alerts");
        alertPage.clickPromptButton();
        alertPage.setTextAlert(data);
        alertPage.confirmAlert();
        Selenide.Wait().withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.alertIsPresent());
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

        Selenide.Wait().withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.alertIsPresent());
        String actualAlert = alertPage.getTextAlert();
        alertPage.confirmAlert();
        Assert.assertEquals(actualAlert, flag);
    }
}