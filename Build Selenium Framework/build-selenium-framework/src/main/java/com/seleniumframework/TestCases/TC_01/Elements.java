package com.seleniumframework.TestCases.TC_01;

import org.openqa.selenium.By;

public class Elements {
    public static By usernameInput = By.id("user-name");
    public static By passwordInput = By.id("password");
    public static By loginBtn = By.id("login-button");
    public static By divProducts = By.id("inventory_container");
    public static By selectFilter = By.xpath("//select[@class='product_sort_container']");
    public static By selectThirdProduct = By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']");
}
