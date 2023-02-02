package com.automation.commons;

import com.automation.utils.DriverUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserSynchronization extends DriverUtils {

    @Test
    public void learnWaits() {
        WebDriver driver = getDriver();
        //Creating an object of WebDriverWait class and passing the driver (to access current driver session) and
        //the duration of seconds we want to wait for the expected condition to be true
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //We can find this element by:
        //xpath //button[@id='startStopButton']
        //Id startStopButton
        //Css #startStopButton
        WebElement startButton = driver.findElement(By.xpath("//button[@id='startStopButton']"));

        //xpath //div[@role='progressbar']
        //Css #progressBar div.progress-bar
        WebElement progressBar = driver.findElement(By.cssSelector("#progressBar div.progress-bar"));

        startButton.click();

        String expectedValue = "100%";

        //Using our driverWait variable to call until method to wait for textToBePresentInElement() condition to return true
        //Note: if the condition is true before the time is up it will not wait for the full time
        driverWait.until(ExpectedConditions.textToBePresentInElement(progressBar, "100%"));

        Assert.assertTrue("Value does not match expected " + expectedValue, progressBar.getText().contains(expectedValue));
    }

    @Before
    public void setUp(){
        createDriver("https://demoqa.com/progress-bar");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
