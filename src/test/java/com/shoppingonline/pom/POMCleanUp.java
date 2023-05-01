package com.shoppingonline.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class POMCleanUp {

    WebDriver driver;

    public POMCleanUp(WebDriver driver) {
        this.driver = driver;
    }

    public void login() throws Exception {
        Thread.sleep(1000);
        driver.findElement(POMElements.Account_name).click();
        driver.findElement(POMElements.Account_to_login).click();
        driver.findElement(POMElements.Login_Email).clear();
        driver.findElement(POMElements.Login_Email).sendKeys(POMElements.user_email);
        driver.findElement(POMElements.Login_Password).clear();
        driver.findElement(POMElements.Login_Password).sendKeys(POMElements.user_password);
        driver.findElement(POMElements.Login_Button).click();
    }

    public void cleanUpWishlist() {
        driver.findElement(POMElements.Go_To_Wishlist).click();
        List<WebElement> tlist = driver.findElements(POMElements.Trash_Wishlist);
        for (WebElement webElement : tlist) webElement.click();
    }

    public void logout() {
        driver.findElement(POMElements.Account_name).click();
        driver.findElement(POMElements.Account_to_logout).click();
    }

    public void cleanUpCart() {
        driver.findElement(POMElements.Go_To_Cart).click();
        driver.findElement(POMElements.Go_To_Cart_Edit_Button).click();
        List<WebElement> tlist = driver.findElements(POMElements.Trash_Cart);
        for (WebElement webElement : tlist) webElement.click();
    }
}
