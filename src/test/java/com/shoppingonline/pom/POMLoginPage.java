package com.shoppingonline.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class POMLoginPage {

    // Login credentials
    static final String user_email = "otheruser@gmail.com";
    static final String user_password = "support";

    // Login
    static final By Login_Email = By.xpath("//*[@id='login']/div[1]/input");
    static final By Login_Password = By.xpath("//*[@id='login']/div[2]/input");
    static final By Login_Button = By.xpath("//*[@id='login']/div[4]/div/button");

    WebDriver driver;

    public POMLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login() throws Exception {
        Thread.sleep(1000);
        driver.findElement(Login_Email).clear();
        driver.findElement(Login_Email).sendKeys(user_email);
        driver.findElement(Login_Password).clear();
        driver.findElement(Login_Password).sendKeys(user_password);
        driver.findElement(Login_Button).click();
    }
}
