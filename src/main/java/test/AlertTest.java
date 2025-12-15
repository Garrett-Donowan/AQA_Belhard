package test;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import java.time.LocalDate;
import java.util.*;


public class AlertTest extends BaseTest{

    private static final Logger logger = LogManager.getLogger(AlertTest.class);

    @Test
    @Epic("Alerts")
    @Feature("Alerts test")
    @Story("someStory")
    public void testAlert(){
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

        logger.info("Приложение запущено!");
        logger.warn("Это предупреждение.");
        logger.error("Произошла ошибка!");

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