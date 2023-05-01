package com.shoppingonline.pom;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class POMCommon {

    WebDriver driver;

    public POMCommon(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkHomePage() throws NoSuchElementException {
        return driver.findElement(POMElements.Account_name).isDisplayed();
    }

    public void clickOnHeaderMenu() throws NoSuchElementException {
        driver.findElement(POMElements.FurnitureHeader).click();
    }
}
