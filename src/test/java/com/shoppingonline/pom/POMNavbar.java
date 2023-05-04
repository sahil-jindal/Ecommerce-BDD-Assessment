package com.shoppingonline.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class POMNavbar {

    // Part of Orders where user can search for items, check wish list and cart.
    static final By SelectCategory = By.xpath("//div[@class='header-search']//select[@class='input-select']");
    static final By SearchItem = By.xpath("//input[@id='search']");
    static final By SearchButton = By.xpath("//button[@id='search_btn']");
    static final By Go_To_Wishlist = By.xpath("//*[@id='header']/div/div/div[3]/div/div[1]/a");
    static final By Go_To_Cart = By.xpath("//*[@id='header']/div/div/div[3]/div/div[2]/a");
    static final By Go_To_Cart_Edit_Button = By.xpath("//*[@id='header']/div/div/div[3]/div/div[2]/div/div[2]/a");

    WebDriver driver;

    public POMNavbar(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCategory(String catog) throws NoSuchElementException {
        new Select(driver.findElement(SelectCategory)).selectByVisibleText(catog);
    }

    public void enterItem(String item) throws Exception {
        driver.findElement(SearchItem).clear();
        driver.findElement(SearchItem).sendKeys(item);
        Thread.sleep(1000);
    }

    public void clickOnSearchButton() throws NoSuchElementException {
        driver.findElement(SearchButton).click();
    }

    public void goToWishList() {
        driver.findElement(Go_To_Wishlist).click();
    }

    public void goToEditCart() throws Exception {
        driver.findElement(Go_To_Cart).click();
        driver.findElement(Go_To_Cart_Edit_Button).click();
        Thread.sleep(1000);
    }
}
