package com.shoppingonline.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class POMAccount {

    static final By Account_name = By.xpath("//*[@id='top-header']/div/ul[2]/li[2]/div/a");
    static final By Account_to_login = By.xpath("//*[@id='top-header']/div/ul[2]/li[2]/div/div/a[2]");
    static final By Account_to_logout = By.xpath("//*[@id='top-header']/div/ul[2]/li[2]/div/div/a[3]");

    WebDriver driver;

    public POMAccount(WebDriver driver) {
        this.driver = driver;
    }

    public void goToLoginPage() {
        driver.findElement(Account_name).click();
        driver.findElement(Account_to_login).click();
    }

    public void logout() {
        driver.findElement(Account_name).click();
        driver.findElement(Account_to_logout).click();
    }

    public boolean checkHomePage() throws NoSuchElementException {
        return driver.findElement(Account_name).isDisplayed();
    }
}
