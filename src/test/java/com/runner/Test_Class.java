package com.runner;

import com.base.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test_Class extends Base_Class {
    public static void main(String[] args){
        launchBrowser("chrome");
        //launchUrl("https://www.amazon.in");
        //launchUrl("https://www.google.com/");
        //navigateToMethods("https://www.facebook.com","to");
        //navigateToMethods("https://www.instagram.com/","to");

        //navigateToMethods("https://www.amazon.in","to");
        launchUrl("https://www.amazon.in/");
        //WebElement element= driver.findElement(By.xpath("//select[@name='url']"));
        WebElement element = driver.findElement(By.xpath("(//span[text()='All'])[1]"));
        actionMethods(element,"move");

        actionMethods(element,"click");

//        navigateToMethods("","back");
//        navigateToMethods("","back");
//        navigateToMethods("","forward");
//        navigateToMethods("","refresh");
//        navigateToMethods("","back");
//        navigateToMethods("","back");
//
//       WebElement element = driver.findElement(By.name("q"));
//        passInput(element,"selenium");
//        windowHandles(1);
//        browserTerminate();
//
//
//
//         WebElement element = driver.findElement(By.id("alertButton"));
//        simpleAndConfirmAlert(element);
//
//        WebElement element1= driver.findElement(By.id("promtButton"));
//        promptAlertMethod(element1,"nadhiya");

//
//        browserTerminate();



    }
}
