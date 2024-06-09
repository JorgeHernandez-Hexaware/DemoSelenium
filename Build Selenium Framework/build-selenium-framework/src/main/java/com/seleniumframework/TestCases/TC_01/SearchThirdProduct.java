package com.seleniumframework.TestCases.TC_01;

import java.util.Arrays;
import java.util.List;

import com.seleniumframework.Models.Browser;
import com.seleniumframework.Models.Step;
import com.seleniumframework.Models.TestCase;

public class SearchThirdProduct extends TestCase{

    public SearchThirdProduct(Browser _browser){
        this.browser = _browser;
        this.name = "Login To Sauce Demo App";
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

    private void validateProductsPage() throws Exception{
        driver.findElement(Elements.divProducts);
    }

    private void selectProduct() throws Exception{
        driver.findElement(Elements.selectThirdProduct).click();
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
       Step fifth = new Step("Validate Products"){
        public void executeStep() throws Exception{
            validateProductsPage();
        }
       };
       Step six = new Step("Select Product"){
        public void executeStep() throws Exception{
            selectProduct();
        }
       };
       return Arrays.asList(first, second, third, fourth, fifth, six);
    }

}
