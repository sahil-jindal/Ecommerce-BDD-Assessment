package com.shoppingonline.pom;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class POMWishList {

    WebDriver driver;

    public POMWishList(WebDriver driver) {
        this.driver = driver;
    }

    public String addToWishlist() {
        String item = driver.findElements(POMElements.Item_name_list).get(0).getText();
        driver.findElement(POMElements.Add_To_Wishlist).click();
        return item;
    }

    public boolean validateWishlist(String item1, String item2) {
        driver.findElement(POMElements.Go_To_Wishlist).click();
        List<WebElement> ilist = driver.findElements(POMElements.Item_name_Wishlist);

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
        driver.findElement(By.xpath(POMElements.Trash_Wishlist1 + item1 + POMElements.Trash_Wishlist2)).click();
    }

    public boolean validateWishlist(String item2) throws Exception {
        Thread.sleep(2000);
        driver.findElement(POMElements.Go_To_Wishlist).click();
        List<WebElement> ilist = driver.findElements(POMElements.Item_name_Wishlist);
		return ilist.get(0).getText().toUpperCase().contains(item2.toUpperCase());
	}
}
