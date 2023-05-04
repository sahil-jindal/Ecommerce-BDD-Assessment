package com.shoppingonline.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class POMWishList {

    static final By Item_name_Wishlist = By.xpath("//*[@id='wishlist']/tbody/tr/td[1]/div/div[1]/h4/a");
    static final String Trash_Wishlist1 = "//*[@id='wishlist']/tbody/tr/td[1]/div/div[1]/h4/a[contains(text(),'";
    static final String Trash_Wishlist2 = "')]/ancestor::tr/td[4]/div/a/i";
    static final By WishList_To_Cart = By.xpath("//*[@id='product']");
    static final By Trash_Wishlist = By.xpath("//*[@id='wishlist']/tbody/tr/td[4]//a");

    WebDriver driver;

    public POMWishList(WebDriver driver) {
        this.driver = driver;
    }

    public boolean validateWishlist(String item1, String item2) {
        List<WebElement> ilist = driver.findElements(Item_name_Wishlist);

        int count = 0;

        for (WebElement webElement : ilist) {
            String itemName = webElement.getText().toUpperCase();
            if (itemName.contains(item1.toUpperCase()) || itemName.contains(item2.toUpperCase())) {
                count = count + 1;
            }
        }

        return count == 2;
    }

    public void removeFromWishlist(String item1) {
        driver.findElement(By.xpath(Trash_Wishlist1 + item1 + Trash_Wishlist2)).click();
    }

    public boolean validateWishlist(String item2) throws Exception {
        Thread.sleep(2000);
        List<WebElement> ilist = driver.findElements(Item_name_Wishlist);
        return ilist.get(0).getText().toUpperCase().contains(item2.toUpperCase());
    }

    public void WishListToCart() {
        List<WebElement> ilist = driver.findElements(WishList_To_Cart);
        for (WebElement webElement : ilist)
            webElement.click();
    }

    public void cleanUpWishlist() {
        List<WebElement> tlist = driver.findElements(Trash_Wishlist);
        for (WebElement webElement : tlist)
            webElement.click();
    }
}
