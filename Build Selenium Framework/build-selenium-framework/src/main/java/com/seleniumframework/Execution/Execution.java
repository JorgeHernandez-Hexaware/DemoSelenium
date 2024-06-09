package com.seleniumframework.Execution;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.seleniumframework.Logger.Logger;
import com.seleniumframework.Models.Browser;
import com.seleniumframework.Models.Step;
import com.seleniumframework.Models.TestCase;

public class Execution {

    private Logger log;

    public Execution(TestCase[] testCases){
        log = new Logger();
        executeTestCases(testCases);
    }

    public void executeTestCases(TestCase[] testCases){
        for (TestCase testCase : testCases) {
            run(testCase); //Method to execute a single test case
        }
    }

    public void run(TestCase testCase){
        Browser browser = testCase.browser;

        DriverHandler.setSystemProperty(browser);
        WebDriver driver =  DriverHandler.createDriver(browser);
        log.startExecution(testCase.name, browser);

        testCase.setDriver(driver);
        List<Step> steps = testCase.getSteps();
        
        // int stepNumber = 0;
        boolean tcStatus = true;

        for (int i = 0; i < steps.size(); i++) {
            Step step = steps.get(i);
            try {
                log.logSteps(step, i+1);
                step.executeStep();
            } catch (Exception e) {
                tcStatus = false;
                System.out.println(e.getMessage());
            }
        }
        log.endExecution(tcStatus);
        driver.quit();
    }

}