package com.seleniumframework.TestCases.TC_02;

import org.openqa.selenium.By;

public class Elements {
    public static By usernameInput = By.xpath("//input[@id='user-name']");
    public static By passwordInput = By.id("password");
    public static By loginBtn = By.id("login-button");
    public static By divProducts = By.id("inventory_container");
    public static By selectFilter = By.xpath("//select[@class='product_sort_container']");
    public static By selectThirdProduct = By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']");
    public static By lastProductPrice = By.xpath("//a[@id='item_5_title_link']");
    public static By btnAddToCart= By.xpath("//button[@class='btn_primary btn_inventory']");
    public static By btnCart = By.id("shopping_cart_container");
    public static By btnCheckOut = By.xpath("//a[@class='btn_action checkout_button']");
    public static By inpFirstName = By.id("first-name");
    public static By inpLastName = By.id("last-name");
    public static By inpPostalCode = By.id("postal-code");
    public static By inpContinue = By.xpath("//input[@class='btn_primary cart_button']");
    public static By btnFinish = By.xpath("//a[@class='btn_action cart_button']");
    public static By screenOrderComplete = By.id("checkout_complete_container");
}