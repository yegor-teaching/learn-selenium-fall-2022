package com.automation.commons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HandlingIframes extends CommonMethods{

    @Test
    public void learnIframeHandling() throws InterruptedException {
        WebDriver driver = getDriver();

        WebElement iframe1 = driver.findElement(By.xpath("//iframe[@id='frame1']"));

        //Here we are switching into the frame1 iFrame
        driver.switchTo().frame(iframe1);

        System.out.println(driver.findElement(By.tagName("h1")).getText());

        //Here we are going back to the parent frame after entering the child frame
        driver.switchTo().parentFrame();

        Thread.sleep(1000);

    }

    @Test
    public void learnNestedIframeHandling() throws InterruptedException {
        WebDriver driver = getDriver();

        driver.navigate().to("https://demoqa.com/nestedframes");

        WebElement frame1 = driver.findElement(By.id("frame1"));

        //Here we are switch into the first (Parent) iFrame so that we can find our nested (Child) iFrame
        driver.switchTo().frame(frame1);

        //Here we are printing out the p tag inside the current frame
        System.out.println(driver.findElement(By.tagName("body")).getText());
        Thread.sleep(2000);

        WebElement frame2 = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));

        //Here we are switch into the second (Child) iFrame
        driver.switchTo().frame(frame2);

        System.out.println(driver.findElement(By.tagName("p")).getText());
        Thread.sleep(2000);

        driver.switchTo().parentFrame();

        System.out.println(driver.findElement(By.tagName("body")).getText());
        Thread.sleep(2000);

        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.tagName("body")).getText());
        Thread.sleep(2000);
    }

    @Before
    public void setUp(){
        createDriver("https://demoqa.com/frames");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
