package test;


import io.qameta.allure.Epic;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

public class SampleAppTest extends BaseTest{

    private static String greenColor = "40, 167, 69";
    private static HashMap<String, String> testData = new HashMap<>();
    {
        testData.put("Trinity", "");
        testData.put("Morpheus", "Knock-Knock");
        testData.put("", "pwd");
        testData.put("Neo", "pwd");
    }

    @Test
    @Description("Проверка обработки полей ввода логина и пароля")
    @Epic("AUTOTEST")
    public void testSampleApp(){

        homePage.redirectToSection("Sample App");
        for (Map.Entry<String, String> el : testData.entrySet()){
            sampleAppPage.enterLoginPwd(el.getKey(), el.getValue());
            sampleAppPage.clickLogInButton();
            String[] labelText = sampleAppPage.loginStatus();

            if (labelText[1].contains(greenColor)){
                String str = String.format("Welcome, %s!", el.getKey());
                Assert.assertEquals(labelText[0], str);
            }
            sampleAppPage.clickLogInButton();
        }
    }
}
