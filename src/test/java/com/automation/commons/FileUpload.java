package com.automation.commons;

import com.automation.utils.DriverUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUpload extends DriverUtils {

    @Test
    public void learnFileUpload() throws InterruptedException {
        WebDriver driver = getDriver();

        WebElement fileUploadInput = driver.findElement(By.cssSelector("#uploadFile"));

        fileUploadInput.sendKeys("/Users/yegorbannov/Desktop/TestFile.txt");

        Thread.sleep(5000);
    }

    @Before
    public void setUp(){
        createDriver("https://demoqa.com/upload-download");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
