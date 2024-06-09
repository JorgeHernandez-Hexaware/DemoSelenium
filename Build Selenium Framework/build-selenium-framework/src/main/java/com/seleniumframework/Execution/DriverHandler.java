package com.seleniumframework.Execution;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.seleniumframework.Models.Actions;
import com.seleniumframework.Models.Browser;
import com.seleniumframework.Models.LocatorTypes;

public class DriverHandler {
    public static WebDriver driver;
    public static Browser browser;

    public DriverHandler(WebDriver _driver){
        driver = _driver;
    }

    public static void setSystemProperty(Browser browser){
        String property;
        String pathWebDriver;

        switch (browser) {
            case Chrome:
                property = "webdriver.chrome.driver";
                pathWebDriver = "C:\\Users\\1000068938\\Documents\\Selenium\\Drivers\\chrome\\chromedriver.exe";
                break;

            case Edge:
                property = "webdriver.msedge.driver";
                pathWebDriver = "C:\\Users\\1000068938\\Documents\\Selenium\\Drivers\\edge\\msedgedriver.exe";
                break;

            case Firefox:
                property = "webdriver.gecko.driver";
                pathWebDriver = "";
                break;

            case Safari:
                property = "webdriver.safari.driver";
                pathWebDriver = "";
                break;

            default:
                property = "webdriver.chrome.driver";
                pathWebDriver = "C:\\Users\\1000068938\\Documents\\Selenium\\Drivers\\chrome\\chromedriver.exe";
                break;
        }

        System.setProperty(property, pathWebDriver);
    }

    public static WebDriver createDriver(Browser _browser){
        browser = _browser;
        
        switch (_browser) {
            case Chrome:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--start-maximized");

                driver = new ChromeDriver(chromeOptions);
                return driver;
                        
            default:
                ChromeOptions defaultOptions = new ChromeOptions();
                defaultOptions.addArguments("--remote-allow-origins=*");
                defaultOptions.addArguments("--start-maximized");

                driver = new ChromeDriver(defaultOptions);
                return driver;
        }
    }

    public static void highlightElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.outline = '#f00 solid 2px' ", element);
    }

    public static void clearHighlightElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.outline = 'none' ", element);
    }

    public static WebElement findElement(LocatorTypes locatorType, String locatorValue) throws Exception{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = null;

        switch (locatorType) {
            case Id:
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
                // element = driver.findElement(By.id(locatorValue));
                break;
            case Xpath:
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
                // element = driver.findElement(By.xpath(locatorValue));
                break;
            case Name:
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
                // element = driver.findElement(By.name(locatorValue));
                break;
            case CssSelector:
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
                // element = driver.findElement(By.cssSelector(locatorValue));
                break;
            case ClassName:
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
                // element = driver.findElement(By.className(locatorValue));
                break;
            default:
                throw new Exception("Invalid LocatorType" + locatorType);
        }

        if(element != null){
            highlightElement(element);
        }

        return element;
    }

    public static void scrollPage250(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0,250)");
    }

    public static void takeScreenshot(boolean option, String name) throws IOException{
        if(option){
            String ssFolder = "C:\\Users\\1000068938\\Documents\\Selenium\\SS\\%s.png";
            String ssName = String.format(ssFolder, name);
    
            TakesScreenshot ss = (TakesScreenshot)driver;
            File screenShot = ss.getScreenshotAs(OutputType.FILE);
    
            FileUtils.copyFile(screenShot, new File(ssName));
        }
    }

    public static void takeElementScreenShot(WebElement element, String name) throws IOException{
        String ssFolder = "C:\\Users\\1000068938\\Documents\\Selenium\\SS\\%s.png";
            String ssName = String.format(ssFolder, name);
        File scrFile = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(ssName));
    }

    public static void performAction(Actions action, String value, LocatorTypes locatorType, String locatorValue) throws Exception{

        WebElement element = null;

        // if(locatorType == null && locatorValue != null){
        //     driver.quit();
        //     System.out.println("Neede a locator Type");
        //     return;
        // }

        // if(locatorType != null && locatorValue == null){
        //     driver.quit();
        //     System.out.println("Neede a locator Value");
        //     return;
        // }

        // if(locatorType == null && locatorValue == null){
        //     driver.quit();
        //     System.out.println("Neede a locator Type and locator Value");
        //     return;
        // }

        switch (action) {
            case AlertGetText:
                String alertTextVal = driver.switchTo().alert().getText();
                System.out.println(alertTextVal);
                break;
            case AlertSetText:
                Alert alert = driver.switchTo().alert();
                alert.sendKeys(value);
                break;
            case Navigate:
                driver.get(value);
                break;
            case Back:
                driver.navigate().back();
                break;
            case Check:
            case Click:
                findElement(locatorType, locatorValue).click();
                break;
            case Clear:
                findElement(locatorType, locatorValue).clear();
                break;
            case Forward:
                driver.navigate().forward();
                break;
            case FullscreenWindow:
                driver.manage().window().fullscreen();
                break;
            case MaximizeWindow:
                driver.manage().window().maximize();
                break;
            case MinimizeWindow:
                driver.manage().window().minimize();
                break;
            case NewWindow:
                driver.switchTo().newWindow(WindowType.WINDOW);
                break;
            case NewWindowTab:
                driver.switchTo().newWindow(WindowType.TAB);
                break;
            case Refresh:
                driver.navigate().refresh();
                break;
            case Type:
                findElement(locatorType, locatorValue).sendKeys(value);
                break;
            case SelectByIndex:
                Select sel = new Select (findElement(locatorType, locatorValue));
                sel.selectByIndex(Integer.parseInt(value));
                break;
            case SelectByText:
                Select selByText = new Select (findElement(locatorType, locatorValue));
                selByText.selectByVisibleText(value);
                break;
            case SelectByValue:
                Select selByValue = new Select(findElement(locatorType, locatorValue));
                selByValue.selectByValue(value);
                break;
            case SwitchWindow:
                driver.switchTo().window(value);
                System.out.println("Switching page to: " + value);
                break;
            case Uncheck:
                element = findElement(locatorType, locatorValue);
                if(element.isSelected()){
                    element.click();
                    }
                break;
            case ValidateElement://Method only to use the highlightElement method and complement with takeScreenShot to have evidence of a element.
                element =  findElement(locatorType, locatorValue);
                if (element.isDisplayed()){
                    System.out.println("Element located: " + element.getText().toLowerCase());
                    } else {
                        System.out.println("Element not found");
                        }
                break;
            case Wait:
                Thread.sleep(Integer.parseInt(value));
                break;
            default:
                throw new Exception("Action not defined " + action);
        }
    }
}