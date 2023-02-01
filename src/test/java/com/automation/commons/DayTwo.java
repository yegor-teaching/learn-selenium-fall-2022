package com.automation.commons;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DayTwo extends DayOne{

    @Before
    public void setUp(){
        createDriver("https://www.saucedemo.com/");
    }

    @Test
    public void login() throws InterruptedException {
        WebDriver driver = getDriver();

        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        //Login
        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        loginButton.click();

        Thread.sleep(500);
        //Now we are on the product page
        WebElement productsPageTitle = driver.findElement(By.className("title"));

        System.out.println(productsPageTitle.getText());
        Assert.assertTrue("Not on products page", productsPageTitle.isDisplayed());

        List<WebElement> inventoryItemDescriptions = driver.findElements(By.className("inventory_item_desc"));
        List<WebElement> inventoryItemTitles = driver.findElements(By.className("inventory_item_name"));

        for (int i = 0; i < inventoryItemDescriptions.size(); i++){
            System.out.println(inventoryItemTitles.get(i).getText());
            System.out.println(inventoryItemDescriptions.get(i).getText());
            System.out.println("============================");
        }




        Thread.sleep(5000);
    }

    @After
    public void cleanUp(){
        quitDriver();
    }

}
