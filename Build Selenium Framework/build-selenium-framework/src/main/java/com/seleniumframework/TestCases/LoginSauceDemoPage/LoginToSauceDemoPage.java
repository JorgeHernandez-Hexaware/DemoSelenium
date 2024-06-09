package com.seleniumframework.TestCases.LoginSauceDemoPage;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.seleniumframework.Models.Browser;
import com.seleniumframework.Models.Step;
import com.seleniumframework.Models.TestCase;

public class LoginToSauceDemoPage extends TestCase{

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public LoginToSauceDemoPage(Browser _browser){
        this.browser = _browser;
        name = "Login To Sauce Demo App";
    }

    private void navigateToSauceDemoApp() throws Exception{
        driver.get("https://www.saucedemo.com/v1/index.html");
    }

    private void typoeUsername() throws Exception{
        driver.findElement(Elements.usernameInput).sendKeys("standard_user");
    }

    private void typePassword() throws Exception{
        driver.findElement(Elements.passwordInput).sendKeys("secret_sauce");
    }

    private void submitCredentials() throws Exception{
        driver.findElement(Elements.loginBtn).click();
    }

    @Override
    public List<Step> getSteps(){
       Step first = new Step("Navigate To Sauce Demo Page"){
           public void executeStep() throws Exception{
            navigateToSauceDemoApp();
        }
       };

       Step second = new Step("Type User Name"){
        public void executeStep() throws Exception{
            typoeUsername();
        }
       };

       Step third = new Step("Type Password"){
        public void executeStep() throws Exception{
            typePassword();
        }
       };

       Step fourth = new Step("Submit Credentials"){
        public void executeStep() throws Exception{
            submitCredentials();
        }
       };

       return Arrays.asList(first, second, third, fourth);
    }

    
}