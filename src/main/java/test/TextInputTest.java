package test;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.lang.reflect.Array;

public class TextInputTest extends BaseTest{

    @Test
    public void testTextField() {
        Selenide.open();
        final String[] testText = {"Lorem", "ipsum", "dolor", "sit", "amet"};

        HomePage.redirectToSection("Text Input");
        for (String el : testText){
            textInputPage.sendData(el);
            textInputPage.clickButton();
            Assert.assertEquals(textInputPage.getButtonText(), el);
            textInputPage.clearField();
        }
    }
}
