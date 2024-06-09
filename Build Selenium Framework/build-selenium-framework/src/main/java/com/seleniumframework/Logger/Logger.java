package com.seleniumframework.Logger;

import com.seleniumframework.Models.Browser;
import com.seleniumframework.Models.Step;

public class Logger {

    public Logger(){}

    public void startExecution(String tcName, Browser browser){
        System.out.println("=============== Start Execution ===============");

        String msg = "";
        
        if(tcName != null){
            msg = "Test Case to Execute: " + tcName;
        } else{
            msg = "Test Case to Execute without name";
        }

        if(browser != null){
            msg.concat(" in " + browser);
        } else {
            msg.concat(" in default browser");
        }

        System.err.println(msg);
    }

    public void logSteps(Step step, int stepNumber){
        String msg = "";

        if (step != null) {
            msg = "Step " + stepNumber + ": " + step.name;
        }

        System.out.println(msg);
    }

    public void endExecution(boolean status){
        String msg = status ? "=============== Finised status Successfully ===============" : "=============== Finished status Failed ===============";
        System.out.println(msg);
    }
}