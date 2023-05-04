package com.shoppingonline.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StepDefinitions.Cart;
import StepDefinitions.Wishlist;

public class POMCart {

    static final String Cart_Quantity1 = "//*[@id='cart']/tbody/tr[";
    static final String Cart_Quantity2 = "]/td[3]/input";
    static final By Cart_Item_name = By.xpath("//*[@id='cart']/tbody/tr/td[1]/div/div[1]/h4/a");
    static final String Cart_Item_Price1 = "//*[@id='cart']/tbody/tr[";
    static final String Cart_Item_Price2 = "]/td[2]/input";
    static final By Cart_Total = By.xpath("//*[@id='cart']/tfoot/tr/td[3]/b");
    static final By Trash_Cart = By.xpath("//*[@id='cart']/tbody/tr/td[5]/div/a[2]");

    WebDriver driver;

    public POMCart(WebDriver driver) {
        this.driver = driver;
    }

    public boolean validateCart(String item1, String item2) {
        List<WebElement> ilist = driver.findElements(Cart_Item_name);

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
        List<WebElement> itemNames = driver.findElements(Cart_Item_name);

        for (int i = 0; i < itemNames.size(); i++) {
            String itemName = itemNames.get(i).getText().toUpperCase();

            if (itemName.contains(Wishlist.Item1)) {
                id1 = i + 1;
            } else if (itemName.contains(Wishlist.Item2)) {
                id2 = i + 1;
            }
        }

        Cart.item1price = driver.findElement(By.xpath(Cart_Item_Price1 + id1 + Cart_Item_Price2)).getAttribute("value");
        Cart.item2price = driver.findElement(By.xpath(Cart_Item_Price1 + id2 + Cart_Item_Price2)).getAttribute("value");

        driver.findElement(By.xpath(Cart_Quantity1 + id1 + Cart_Quantity2)).clear();
        driver.findElement(By.xpath(Cart_Quantity1 + id1 + Cart_Quantity2)).sendKeys(quantity1);
        Thread.sleep(1000);

        driver.findElement(By.xpath(Cart_Quantity1 + id2 + Cart_Quantity2)).clear();
        driver.findElement(By.xpath(Cart_Quantity1 + id2 + Cart_Quantity2)).sendKeys(quantity2);
        Thread.sleep(1000);
    }

    public boolean validateUpdateCart(String finalTotal) throws Exception {
        Thread.sleep(2000);
        String totalDisplayed = driver.findElement(Cart_Total).getText().split(" ")[3];
        return (Integer.parseInt(totalDisplayed)) == (Integer.parseInt(finalTotal));
    }

    public void cleanUpCart() {
        List<WebElement> tlist = driver.findElements(Trash_Cart);
        for (WebElement webElement : tlist)
            webElement.click();
    }
}
