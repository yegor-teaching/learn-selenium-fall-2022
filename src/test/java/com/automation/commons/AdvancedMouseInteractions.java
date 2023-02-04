package com.automation.commons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class AdvancedMouseInteractions extends CommonMethods{

    @Test
    public void learnAdvancedMouseInteractions() throws InterruptedException {
        WebDriver driver = getDriver();

        //Creating an object of the actions class and passing webdriver as a parameter to its constructor
        Actions actions = new Actions(driver);

        WebElement doubleClickBtn = driver.findElement(By.xpath("//button[contains(text(),'Double')]"));
        WebElement rightClickBtn = driver.findElement(By.xpath("//button[contains(text(),'Right')]"));

        //Actions class has a lot of different methods to perform various different advanced mouse interactions and actions
        //In this case we are calling the .doubleClick() method and passing the element we wait to double click on
        //We are the calling the .build() method in order to build the actual sequence
        //And then the .perform() method which actually performs the actions
        //actions.doubleClick(doubleClickBtn).build().perform();

        //In this case we are performing the same double click but we are using the .moveToElement() method to first
        //move the "mouse" to the element and then perform the double click
        actions.moveToElement(doubleClickBtn).doubleClick().perform();

        Thread.sleep(3000);

        //The actions .contextClick() method will perform a right click/context click (synonyms) on the webelement that is passed
        //as a parameter
        actions.contextClick(rightClickBtn).build().perform();

        Thread.sleep(3000);

        driver.navigate().to("http://the-internet.herokuapp.com/hovers");

        Thread.sleep(1000);

        WebElement hoverIcon = driver.findElement(By.xpath("//div[@class='figure'][1]"));

        //Here we are using the .moveToElement() method to essentially hover over a specific element
        actions.moveToElement(hoverIcon).build().perform();

        Thread.sleep(3000);

        WebElement viewProfileLink = driver.findElement(By.xpath("//div[@class='figure'][1]//a"));

        actions.keyDown(Keys.COMMAND).click(viewProfileLink).keyUp(Keys.COMMAND).build().perform();

        Thread.sleep(3000);
    }

    @Test
    public void learnDragAndDrop() throws InterruptedException {
        WebDriver driver = getDriver();
        Actions actions = new Actions(driver);

        driver.navigate().to("https://demoqa.com/droppable");

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        //dragAndDrop(WebElement, WebElement) method will drag the first parameter passed to the location of second
        //parameter passed
        actions.dragAndDrop(draggable, droppable).build().perform();

        Thread.sleep(3000);

        driver.navigate().to("https://demoqa.com/slider");

        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));

        //dragAndDropBy(WebElement, xOffset, yOffset) method will drag the element by the given x and y offset
        actions.dragAndDropBy(slider, -50, 0).build().perform();
        Thread.sleep(1000);
        actions.dragAndDropBy(slider, 70, 0).build().perform();

        Thread.sleep(5000);
    }

    @Test
    public void learnScroll() throws InterruptedException {
        WebDriver driver = getDriver();
        Actions actions = new Actions(driver);

        driver.navigate().to("https://www.saucedemo.com/inventory.html");

        loginToSauceDemo();

        WebElement sauceLabsOnesie = driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']"));

        Thread.sleep(3000);

        //scrollToElement() method will scroll to the WebElement passed as the parameter
        //actions.scrollToElement(sauceLabsOnesie).build().perform();

        //Thread.sleep(3000);

        //scrollByAmount() method will scroll by the specified amount on the x and y
        actions.scrollByAmount(0, 500).build().perform();

        Thread.sleep(3000);
    }

    @Before
    public void setUp(){
        createDriver("https://demoqa.com/buttons");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
