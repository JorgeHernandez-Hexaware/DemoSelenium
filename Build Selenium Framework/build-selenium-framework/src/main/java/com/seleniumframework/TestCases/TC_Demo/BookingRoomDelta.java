package com.seleniumframework.TestCases.TC_Demo;

import java.util.Arrays;
import java.util.List;

import com.seleniumframework.Execution.DriverHandler;
import com.seleniumframework.Models.Actions;
import com.seleniumframework.Models.Browser;
import com.seleniumframework.Models.LocatorTypes;
import com.seleniumframework.Models.Step;
import com.seleniumframework.Models.TestCase;

public class BookingRoomDelta extends TestCase{
    public BookingRoomDelta(Browser _browser){
        this.browser = _browser;
        this.name = "Booking Room";
    }

    //Used to manage windows
    String originalWindow="";
    String secondWindow="";
    String thirdWindow=""; 

    private void navigateToDelta(String _name) throws Exception{
        DriverHandler.performAction(Actions.Navigate, "https://www.delta.com", null, null);
    }

    private void selectLanguage(String _name) throws Exception{
        DriverHandler.performAction(Actions.Click, "", LocatorTypes.Xpath, "//button[text()=' México - Español ']");
    }

    private void goToComprarHoteles(String _name) throws Exception{
        originalWindow = driver.getWindowHandle();//Get the identifier of the first window
        DriverHandler.scrollPage250();
        DriverHandler.performAction(Actions.Click, "", LocatorTypes.Xpath, "//li[@class='shopping-link-2']");
        DriverHandler.takeScreenshot(true, _name);
        for(String window: driver.getWindowHandles()){
            if(!originalWindow.contentEquals(window)){
                DriverHandler.performAction(Actions.SwitchWindow, window, null, _name);
            }
        }
        secondWindow = driver.getWindowHandle(); //Get the identifier of the second window
    }

    private void validateStaysPage(String _name) throws Exception{
        DriverHandler.performAction(Actions.ValidateElement, "", LocatorTypes.Xpath, "//div[contains(text(),'Search Stays')]");
        DriverHandler.takeScreenshot(true, _name);
    }

    private void selectDestination(String _name) throws Exception{
        DriverHandler.performAction(Actions.Click, "", LocatorTypes.Xpath, "//button[@aria-label = 'Going to']"); //To display list of destinations to search
        DriverHandler.performAction(Actions.Type, "GDL", LocatorTypes.Id, "location-field-destination");
        DriverHandler.performAction(Actions.Click, "", LocatorTypes.Xpath, "//button[@aria-label='Guadalajara (GDL - Don Miguel Hidalgo y Costilla Intl.) Jalisco, Mexico']");
        DriverHandler.takeScreenshot(true, _name);
    }

    private void selectDates(String _name) throws Exception{
        DriverHandler.performAction(Actions.Click, "", LocatorTypes.Id, "d1-btn");
        DriverHandler.performAction(Actions.Click, "", LocatorTypes.Xpath, "(//button[@data-day=17])[1]");
        DriverHandler.performAction(Actions.Click, "", LocatorTypes.Xpath, "(//button[@data-day=21])[1]");
        DriverHandler.takeScreenshot(true, _name);
        DriverHandler.performAction(Actions.Click, "", LocatorTypes.Xpath, "(//button[text()='Done'])[2]");
        DriverHandler.takeScreenshot(true, _name + " 2");
    }

    public void searchStays(String _name) throws Exception{
        DriverHandler.performAction(Actions.Click, "", LocatorTypes.Xpath, "//button[@type='submit']");
        DriverHandler.takeScreenshot(true, _name);
    }

    public void selectFilters(String _name) throws Exception{
        DriverHandler.performAction(Actions.Click, "", LocatorTypes.CssSelector, "#amenities-POOL-d8i");
        Thread.sleep(6000);
    }

    public void selectHotel(String _name) throws Exception{
        DriverHandler.performAction(Actions.Click, "", LocatorTypes.Xpath, "(//div/h3[contains(text(),'Hotel Riu Plaza Guadalajara')])[2]");
        DriverHandler.takeScreenshot(true, _name);
    }

    @Override
    public List<Step> getSteps(){
        Step step1 = new Step("1_Navigate_To_Delta"){
            public void executeStep() throws Exception{
                navigateToDelta(this.name);
            }
        };

        Step step2 = new Step("2_Select_Language"){
            public void executeStep() throws Exception{
                selectLanguage(this.name);
            }
        };

        Step step3 = new Step("3_Go_To_Comprar_Hoteles"){
            public void executeStep() throws Exception{
                goToComprarHoteles(this.name);
            }
        };

        Step step4 = new Step("4_Validate_Search_Stays_Page"){
            public void executeStep() throws Exception{
                validateStaysPage(this.name);
            }
        };

        Step step5 = new Step("5_Select_Destination"){
            public void executeStep() throws Exception{
                selectDestination(this.name);
            }
        };

        Step step6 = new Step("6_Select_Dates"){
            public void executeStep() throws Exception{
                selectDates(this.name);
            }
        };

        Step step7 = new Step("7_SearchStays"){
            public void executeStep() throws Exception{
                searchStays(this.name);
            }
        };

        Step step8 = new Step("8_Select_Filters"){
            public void executeStep() throws Exception{
                selectFilters(this.name);
            }  
        };

        Step step9 = new Step("9_Select_Hotel"){
            public void executeStep() throws Exception{
                selectHotel(this.name);
            }
        };

        return Arrays.asList(step1, step2, step3, step4, step5, step6, step7, step8);
    }
}
