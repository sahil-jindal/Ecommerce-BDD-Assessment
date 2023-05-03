package com.shoppingonline.pom;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class POMCategories {

    static final By FurnitureHeader = By.xpath("//a[contains(text(),'Furnitures')]");
    static final String Header_category1 = "//a[contains(text(),'";
    static final String Header_category2 = "')]";

    public static final HashMap<String, Integer> urlMap = new HashMap<>();

    static {
        urlMap.put("Electronics", 1);
        urlMap.put("Kids Wear", 4);
        urlMap.put("Furnitures", 5);
        urlMap.put("Home Appliances", 6);
        urlMap.put("Electronics Gadgets", 7);
    }

    WebDriver driver;

    public POMCategories(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnHeaderMenu() throws NoSuchElementException {
        driver.findElement(FurnitureHeader).click();
    }

    public void selectItem(String item) {
        driver.findElement(By.xpath(Header_category1 + item + Header_category2)).click();
    }

    public boolean validateURL(String item) {
        String url = driver.getCurrentUrl();
        String id = url.substring(url.indexOf("=") + 1);
        return urlMap.get(item) == Integer.parseInt(id);
    }
}
