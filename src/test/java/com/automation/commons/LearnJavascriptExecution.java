package com.automation.commons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LearnJavascriptExecution extends CommonMethods{

    @Test
    public void learnJsExecutor() throws InterruptedException {
        WebDriver driver = getDriver();

        //Since ChromeDriver implements JavascriptExecutor interface we can create an instance by just typecasting it
        //to JavascriptExecutor
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        WebElement hotSellersTitle = driver.findElement(By.xpath("//h2[@class='title']"));

        Thread.sleep(3000);

        //Here we are calling the .executeScript() method and passing a JS snippet (script) in order to scroll down by 500 px
        jsExecutor.executeScript("window.scrollBy(0,500)");

        Thread.sleep(3000);

        //Here we are retrieving the Y coordinate of the hotSellersTitle WebElement on the page
        int yPositionOfHotSellers = hotSellersTitle.getLocation().getY();

        //Here we are passing the y value of the hotSellersTitle position and concatenating it to the string script
        jsExecutor.executeScript("window.scrollBy(0," + yPositionOfHotSellers + ")");

        Thread.sleep(3000);

        //Here we are using a different script and passing a variable WebElement as an argument to the JS script
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", hotSellersTitle);

        Thread.sleep(3000);
    }

    @Before
    public void setUp(){
        createDriver("https://magento.softwaretestingboard.com/");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
