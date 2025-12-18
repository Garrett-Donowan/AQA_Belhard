package listeners;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.*;
import test.BaseTest;

public class TestListener implements ITestListener, IInvokedMethodListener {

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult result, ITestContext context){
        if (method.isConfigurationMethod() || method.isTestMethod()){
            int status = result.getStatus();
            if (status != 1 && WebDriverRunner.hasWebDriverStarted()){
                try{
                    BaseTest.getScreenshotes();
                } catch (Exception e){
                    e.getCause();
                }
            }
        }

    }
}
