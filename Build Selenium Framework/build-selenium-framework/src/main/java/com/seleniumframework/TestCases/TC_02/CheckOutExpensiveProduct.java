package com.seleniumframework.TestCases.TC_02;

import java.util.Arrays;
import java.util.List;

import com.seleniumframework.Execution.DriverHandler;
import com.seleniumframework.Models.Actions;
import com.seleniumframework.Models.Browser;
import com.seleniumframework.Models.LocatorTypes;
import com.seleniumframework.Models.Step;
import com.seleniumframework.Models.TestCase;

public class CheckOutExpensiveProduct extends TestCase{
    // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public CheckOutExpensiveProduct(Browser _browser){
        this.browser = _browser;
        this.name = "Login To Sauce Demo App";
    }

    private void navigateToSauceDemoApp(String _name) throws Exception{
        DriverHandler.performAction(Actions.Navigate, "https://www.saucedemo.com/v1/index.html", null, null);
        driver.get("https://www.saucedemo.com/v1/index.html");
        DriverHandler.takeScreenshot(true, _name);
    }

    private void typeUsername(String _name) throws Exception{
        // wait.until(ExpectedConditions.visibilityOfElementLocated(Elements.usernameInput));
        // WebElement username = driver.findElement(Elements.usernameInput);
        // username.sendKeys("standard_user");
        // highlightElement(username);
        // clearHighlightElement(username);
        DriverHandler.performAction(Actions.Type, "standard_user", LocatorTypes.Id, "user-name");
        DriverHandler.takeScreenshot(true, _name);
        
    }

    private void typePassword(String _name) throws Exception{
    //    WebElement password =  driver.findElement(Elements.passwordInput);
    //    password.sendKeys("secret_sauce");
    //    highlightElement(password);
        DriverHandler.performAction(Actions.Type, "secret_sauce", LocatorTypes.Id, "password");
        DriverHandler.takeScreenshot(true, _name);
    }

    private void submitCredentials(String _name) throws Exception{
        // driver.findElement(Elements.loginBtn).click();
        DriverHandler.performAction(Actions.Click, "", LocatorTypes.Id, "login-button");
        DriverHandler.takeScreenshot(true, _name);
    }

    private void validateProductsPage(String _name) throws Exception{
        // driver.findElement(Elements.divProducts);
        DriverHandler.performAction(Actions.ValidateElement, "", LocatorTypes.Id, "inventory_container");
        DriverHandler.takeScreenshot(true, _name);
    }

    private void sortProducts(String _name) throws Exception{
        // driver.findElement(Elements.selectFilter).click();
        DriverHandler.performAction(Actions.SelectByValue, "lohi", LocatorTypes.Xpath, "//select[@class='product_sort_container']");
        DriverHandler.takeScreenshot(true, _name);
    }

    private void selectExpensiveProduct(String _name) throws Exception{
        // driver.findElement(Elements.lastProductPrice).click();
        DriverHandler.performAction(Actions.Click, "", LocatorTypes.Xpath, "//a[@id='item_5_title_link']");
        DriverHandler.takeScreenshot(true, _name);
    }
    
    private void addToCart(String _name) throws Exception{
        // driver.findElement(Elements.btnAddToCart).click();
        DriverHandler.performAction(Actions.Click, "", LocatorTypes.Xpath, "//button[@class='btn_primary btn_inventory']");
        DriverHandler.takeScreenshot(true, _name);
    }
    
    private void cartPage(String _name) throws Exception{
        // driver.findElement(Elements.btnCart).click();
        DriverHandler.performAction(Actions.Click, "", LocatorTypes.Id, "shopping_cart_container");
        DriverHandler.takeScreenshot(true, _name);
    }
    
    private void checkOut(String _name) throws Exception{
        // driver.findElement(Elements.btnCheckOut).click();
        DriverHandler.performAction(Actions.Click, "", LocatorTypes.Xpath, "//a[@class='btn_action checkout_button']");
        DriverHandler.takeScreenshot(true, _name);
    }

    private void typeFirstName(String _name) throws Exception{
        // driver.findElement(Elements.inpFirstName).sendKeys("Jorge");
        DriverHandler.performAction(Actions.Type, "Jorge",  LocatorTypes.Id, "first-name");
        DriverHandler.takeScreenshot(true, _name);
    }
    
    private void typeLastName(String _name) throws Exception{
        // driver.findElement(Elements.inpLastName).sendKeys("Hernandez");
        DriverHandler.performAction(Actions.Type, "Hernandez",  LocatorTypes.Id, "last-name");
        DriverHandler.takeScreenshot(true, _name);
    }
    
    private void typePostalCode(String _name) throws Exception{
        // driver.findElement(Elements.inpPostalCode).sendKeys("12345");
        DriverHandler.performAction(Actions.Type, "12345",  LocatorTypes.Id, "postal-code");
        DriverHandler.takeScreenshot(true, _name);
    }

    private void continueBuy(String _name) throws Exception{
        // driver.findElement(Elements.inpContinue).click();
        DriverHandler.performAction(Actions.Click, "", LocatorTypes.Xpath, "//input[@class='btn_primary cart_button']");
        DriverHandler.takeScreenshot(true, _name);
    }
    
    public void finishBuy(String _name) throws Exception{
        // driver.findElement(Elements.btnFinish).click();
        DriverHandler.performAction(Actions.Click, "", LocatorTypes.Xpath, "//a[@class='btn_action cart_button']");
        DriverHandler.takeScreenshot(true, _name);
    }

    public void orderComplete(String _name) throws Exception{
        // driver.findElement(Elements.screenOrderComplete);
        DriverHandler.performAction(Actions.ValidateElement, "", LocatorTypes.Id, "checkout_complete_container");
        DriverHandler.takeScreenshot(true, _name);
    }

    @Override
    public List<Step> getSteps(){
        Step step1 = new Step("1_Navigate To Sauce Demo Page"){
           public void executeStep() throws Exception{
            navigateToSauceDemoApp(this.name);
        }
       };
       Step step2 = new Step("2_Type User Name"){
        public void executeStep() throws Exception{
            typeUsername(this.name);
        }
       };

       Step step3 = new Step("3_Type Password"){
        public void executeStep() throws Exception{
            typePassword(this.name);
        }
       };

       Step step4 = new Step("4_Submit Credentials"){
        public void executeStep() throws Exception{
            submitCredentials(this.name);
        }
       };

       Step step5 = new Step("5_Validate Products"){
        public void executeStep() throws Exception{
            validateProductsPage(this.name);
        }
       };

       Step step6 = new Step("6_Sort Products"){
        public void executeStep() throws Exception{
            sortProducts(this.name);
        }
       };

       Step step7 = new Step("7_Select Expensive Product"){
        public void executeStep() throws Exception{
            selectExpensiveProduct(this.name);
        }
       };

       Step step8 = new Step("8_Add to Cart"){
        public void executeStep() throws Exception{
            addToCart(this.name);
        }
       };

       Step step9 = new Step("9_Go To Cart"){
        public void executeStep() throws Exception{
            cartPage(this.name);
        }
       };
       
       Step step10 = new Step("10_CheckOut"){
        public void executeStep() throws Exception{
            checkOut(this.name);
        }
       };

       Step step11 = new Step("11_Type First Name"){
        public void executeStep() throws Exception{
            typeFirstName(this.name);
        }
       };

       Step step12 = new Step("12_Type Last Name"){
        public void executeStep() throws Exception{
            typeLastName(this.name);
        }
       };

       Step step13 = new Step("13_Type Postal Code"){
        public void executeStep() throws Exception{
            typePostalCode(this.name);
        }
       };

       Step step14 = new Step("14_Continue with Buy"){
        public void executeStep() throws Exception{
            continueBuy(this.name);
        }
       };

       Step step15 = new Step("15_Finish Buy"){
        public void executeStep() throws Exception{
            finishBuy(this.name);
        }
       };

       Step step16 = new Step("16_Validate Buy"){
        public void executeStep() throws Exception{
            orderComplete(this.name);
        }
       };

       return Arrays.asList(step1, step2, step3, step4, step5, step6, step7, step8, step9, step10, step11, step12, step13, step14, step15, step16);
    }
}