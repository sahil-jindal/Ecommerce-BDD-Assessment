package com.shoppingonline.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StepDefinitions.Cart;
import StepDefinitions.Wishlist;

public class POMCart {

    WebDriver driver;

    public POMCart(WebDriver driver) {
        this.driver = driver;
    }

    public void goToWishList() {
        driver.findElement(POMElements.Go_To_Wishlist).click();
    }

    public void WishListToCart() {
        List<WebElement> ilist = driver.findElements(POMElements.WishList_To_Cart);
        for (WebElement webElement : ilist) {
            webElement.click();
        }
    }

    public void goToEditCart() throws Exception {
        driver.findElement(POMElements.Go_To_Cart).click();
        driver.findElement(POMElements.Go_To_Cart_Edit_Button).click();
        Thread.sleep(1000);
    }

    public boolean validateCart(String item1, String item2) {
        List<WebElement> ilist = driver.findElements(POMElements.Cart_Item_name);

        int count = 0;

        for (WebElement webElement : ilist) {
            String itemName = webElement.getText().toUpperCase();
            if (itemName.contains(item1.toUpperCase()) || itemName.contains(item2.toUpperCase())) {
                count = count + 1;
            }
        }

        return count == 2;
    }

    public void updateCart(String quantity1, String quantity2) throws Exception {
        Thread.sleep(1000);
        int id1 = 0, id2 = 0;
        List<WebElement> itemNames = driver.findElements(POMElements.Cart_Item_name);

        for (int i = 0; i < itemNames.size(); i++) {
            String itemName = itemNames.get(i).getText().toUpperCase();

            if (itemName.contains(Wishlist.Item1)) {
                id1 = i + 1;
            } else if (itemName.contains(Wishlist.Item2)) {
                id2 = i + 1;
            }
        }

        Cart.item1price = driver.findElement(By.xpath(POMElements.Cart_Item_Price1 + id1 + POMElements.Cart_Item_Price2)).getAttribute("value");
        Cart.item2price = driver.findElement(By.xpath(POMElements.Cart_Item_Price1 + id2 + POMElements.Cart_Item_Price2)).getAttribute("value");
        driver.findElement(By.xpath(POMElements.Cart_Quantity1 + id1 + POMElements.Cart_Quantity2)).clear();
        driver.findElement(By.xpath(POMElements.Cart_Quantity1 + id1 + POMElements.Cart_Quantity2)).sendKeys(quantity1);
        Thread.sleep(1000);
        driver.findElement(By.xpath(POMElements.Cart_Quantity1 + id2 + POMElements.Cart_Quantity2)).clear();
        driver.findElement(By.xpath(POMElements.Cart_Quantity1 + id2 + POMElements.Cart_Quantity2)).sendKeys(quantity2);
        Thread.sleep(1000);
    }

    public boolean validateUpdateCart(String finalTotal) throws Exception {
        Thread.sleep(2000);
        String totalDisplayed = driver.findElement(POMElements.Cart_Total).getText().split(" ")[3];
        return (Integer.parseInt(totalDisplayed)) == (Integer.parseInt(finalTotal));
    }
}
