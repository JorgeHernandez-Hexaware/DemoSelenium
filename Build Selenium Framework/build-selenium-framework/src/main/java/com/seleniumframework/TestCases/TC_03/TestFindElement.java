package com.seleniumframework.TestCases.TC_03;

import java.util.Arrays;
import java.util.List;

import com.seleniumframework.Execution.DriverHandler;
import com.seleniumframework.Models.Actions;
import com.seleniumframework.Models.Browser;
import com.seleniumframework.Models.LocatorTypes;
import com.seleniumframework.Models.Step;
import com.seleniumframework.Models.TestCase;

public class TestFindElement extends TestCase{

    public TestFindElement (Browser _browser){
        name = "Test Case to test method findElement from driverHandler";
        this.browser = _browser;
    }

    private void navigateToSauceDemoApp(String _name) throws Exception{
        // driver.get("https://www.saucedemo.com/v1/index.html");
        DriverHandler.performAction(Actions.Navigate, "https://www.saucedemo.com/v1/index.html", null, null);
        DriverHandler.takeScreenshot(true, _name);
    }
    private void typeUsername(String _name) throws Exception{
        // WebElement element = DriverHandler.findElement(LocatorTypes.Id, "user-name");
        // element.sendKeys("standard_user");
        // clearHighlightElement(element);
        DriverHandler.performAction(Actions.Type, "standard_user", LocatorTypes.Id, "user-name");
        DriverHandler.takeScreenshot(true, _name);
    }

    private void typePassword(String _name) throws Exception{
        // WebElement element = DriverHandler.findElement(LocatorTypes.Id, "password");
        // element.sendKeys("secret_sauce");
        // clearHighlightElement(element);
        DriverHandler.performAction(Actions.Type, "secret_sauce", LocatorTypes.Id, "password");
        DriverHandler.takeScreenshot(true, _name);
    }

    private void submitCredentials(String _name) throws Exception{
        // WebElement element = DriverHandler.findElement(LocatorTypes.Id, "login-button");
        // clearHighlightElement(element);
        // element.click();
        DriverHandler.performAction(Actions.Click, "", LocatorTypes.Id, "login-button");
        DriverHandler.takeScreenshot(true, _name);
    }

    @Override
    public List<Step> getSteps(){
        Step step1 = new Step("Navigate To Sauce Demo Page"){
            public void executeStep() throws Exception{
             navigateToSauceDemoApp(this.name);
         }
        };
        Step step2 = new Step("Type User Name"){
         public void executeStep() throws Exception{
             typeUsername(this.name);
         }
        };
 
        Step step3 = new Step("Type Password"){
         public void executeStep() throws Exception{
             typePassword(this.name);
         }
        };
 
        Step step4 = new Step("Submit Credentials"){
         public void executeStep() throws Exception{
             submitCredentials(this.name);
         }
        };
        return Arrays.asList(step1, step2, step3, step4);
    }
}
