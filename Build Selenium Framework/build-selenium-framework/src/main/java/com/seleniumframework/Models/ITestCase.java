package com.seleniumframework.Models;

import java.util.List;

import org.openqa.selenium.WebDriver;

public interface ITestCase {
    public List<Step> getSteps();

    public void setDriver(WebDriver driver);

}
