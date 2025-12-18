package test;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextInputTest extends BaseTest{

    @Test
    @Description("Проверка ввода данных в текстовое поле ввода TextInput")
    @Epic("AUTOTEST")
    public void testTextField() {
        final String[] testText = {"Lorem", "ipsum", "dolor", "sit", "amet"};

        Selenide.open();

        homePage.redirectToSection("Text Input");
        for (String el : testText){
            textInputPage.sendData(el);
            textInputPage.clickButton();
            Assert.assertEquals(textInputPage.getButtonText(), el);
            textInputPage.clearField();
        }
    }
}
