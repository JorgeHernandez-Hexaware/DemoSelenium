package com.seleniumframework.Models;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.seleniumframework.Execution.DriverHandler;

public class TestCase implements ITestCase{

    public String name;
    public Browser browser;
    public WebDriver driver;
    public DriverHandler driverHandler;

    public List<Step> getSteps() {
        return Arrays.asList();
    }

    public void setDriver(WebDriver _driver) {
        this.driver = _driver;
        driverHandler = new DriverHandler(driver);
    }
    
}