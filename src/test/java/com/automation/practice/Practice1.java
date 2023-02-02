package com.automation.practice;

import com.automation.commons.CommonMethods;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Practice1 extends CommonMethods {

    @Test
    public void practice1() throws InterruptedException {
        WebDriver driver = getDriver();

        loginToSauceDemo();

        Thread.sleep(3000);
    }

    @Before
    public void setUp(){
        createDriver("https://www.saucedemo.com/");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
