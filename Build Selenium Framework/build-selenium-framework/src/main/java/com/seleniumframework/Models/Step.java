package com.seleniumframework.Models;

public class Step {

    public String name;
    public String description;
    public boolean status;

    public Step(String _name){
        this.name = _name;
    }

    public void executeStep() throws Exception {}
}
