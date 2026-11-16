package com.base;

import io.opentelemetry.sdk.common.CompletableResultCode;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract  class Base_Class {
    public static WebDriver driver;

    protected static WebDriver  launchBrowser(String browserName) {
        try{
            if(browserName.equalsIgnoreCase("chrome")){
                driver=new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                driver=new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("edge")) {
                driver=new EdgeDriver();
            }
        } catch (Exception e) {
            Assert.fail("error occured during browser launch");
        }
        driver.manage().window().maximize();
        return driver;
    }

    protected static void launchUrl(String url){
        try{
                driver.get(url);
        }
        catch (Exception e) {
            Assert.fail("error ocured during url launch");
        }

    }
    protected static void passInput(WebElement element, String value){
        try{
            element.sendKeys(value);
        } catch (Exception e) {
            Assert.fail("error occured during input");
        }
    }
    protected static void clickOnElement(WebElement element){
        try{
            element.click();
        } catch (Exception e) {
            Assert.fail("error occured during click on element");
        }
    }
    protected static void browserTerminate(){
        try{
            driver.quit();
        } catch (Exception e) {
            Assert.fail("error occured during browser termination");
        }
    }
    protected static void browserClose(){
        try{
            driver.close();
        } catch (Exception e) {
            Assert.fail("error occured during browser close");
        }
    }
    protected static void windowHandles(int num){
        List<String> allWindows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(allWindows.get(num));

    }
    protected static  void selectOptions(WebElement element,String type,String value){
        try {
            Select select= new Select(element);
            if(type.equalsIgnoreCase("index")){
                select.selectByIndex(Integer.parseInt(value));
            }else if(type.equalsIgnoreCase("text")){
                select.selectByVisibleText(value);
            } else if (type.equalsIgnoreCase("value")) {
                select.selectByValue(value);
            }
        }catch (Exception e){
            Assert.fail("ERROR OCCURED DURING SELECT OPTION");
        }
    }
    protected  static  void deSelectOptions(WebElement element,String type, String value){
        try {
            Select select= new Select(element);
            if(type.equalsIgnoreCase("index")){
                select.deselectByIndex(Integer.parseInt(value));
            }else if(type.equalsIgnoreCase("text")){
                select.deselectByVisibleText(value);
            } else if (type.equalsIgnoreCase("value")) {
                select.deselectByValue(value);
            }

        } catch (Exception e) {
            Assert.fail("ERROR OCCURED DURING DESELECT OPTION");

        }
    }

    protected static void navigateToMethods(String url,String type) {

        try {
            if(type.equalsIgnoreCase("to")){
                driver.navigate().to(url );
            } else if (type.equalsIgnoreCase("back")) {
                driver.navigate().back();
            } else if (type.equalsIgnoreCase("forward")) {
                driver.navigate().forward();
            } else if (type.equalsIgnoreCase("refresh")){
                driver.navigate().refresh();
            }
        }
        catch (Exception e){
            Assert.fail("error occured during navigation");

        }
    }

    protected static void simpleAndConfirmAlert(WebElement element){
        try{
            if (element.getText().equalsIgnoreCase("alertButton")){
                element.click();
                driver.switchTo().alert().accept();
            } else if (element.getText().equalsIgnoreCase("confirmButton")) {
                element.click();
                driver.switchTo().alert().accept();
            }
        } catch (Exception e) {
            Assert.fail("error occured during click on element");
        }
    }

    protected static void promptAlertMethod(WebElement element, String value)
    {
        try{
            element.click();
            driver.switchTo().alert().sendKeys(value);
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            Assert.fail("error occured during click on element");
        }
    }
    protected static void dismissAlertMethod(WebElement element){
        try{
            element.click();
            driver.switchTo().alert().dismiss();
        } catch (Exception e) {
            Assert.fail("error occured during click on element");
        }
    }
    protected static void actionMethods(WebElement element,String type){
        try{
            Actions action =new Actions(driver);
            if(type.equalsIgnoreCase("move")){
                action.moveToElement(element).build().perform();
            }else if (type.equalsIgnoreCase("Click")) {
                action.click(element).build().perform();
            }
            else if (type.equalsIgnoreCase("right click")) {
                action.contextClick(element).build().perform();
            }else if(type.equalsIgnoreCase("double click")){
                action.doubleClick(element).build().perform();

            }

        } catch (Exception e) {
            Assert.fail("error occured during click on element");
        }
    }
    protected static void dragAndDrop(WebElement sourceElement,WebElement targetElement){
        try {
            Actions action =new Actions(driver);
            action.dragAndDrop(sourceElement,targetElement).build().perform();
        } catch (Exception e) {
            Assert.fail("error occured during drag and drop");
        }

    }
    protected static void implicitWaitMethods(int duration){
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
        } catch (Exception e) {
            Assert.fail("error occured during implicit wait");
        }
    }



}
