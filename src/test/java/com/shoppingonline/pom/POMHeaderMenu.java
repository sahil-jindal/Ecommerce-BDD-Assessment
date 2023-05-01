package com.shoppingonline.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class POMHeaderMenu {

    WebDriver driver;

    public POMHeaderMenu(WebDriver driver) {
        this.driver = driver;
    }

    public void selectItem(String item) {
        driver.findElement(By.xpath(POMElements.Header_category1 + item + POMElements.Header_category2)).click();
    }

    public boolean validateURL(String item) {
        String url = driver.getCurrentUrl();
        String id = url.substring(url.indexOf("=") + 1);
        return POMElements.urlMap.get(item) == Integer.parseInt(id);
    }

    public boolean validateSearchItem(String name, String orderPrice, String discountPrice) {
        boolean check = false;

        List<WebElement> ilist = driver.findElements(POMElements.Item_name_list);
        List<WebElement> prlist = driver.findElements(POMElements.Item_price_list);

        for (int j = 0; j < ilist.size(); j++) {
            int found = 0;

            String itemName = ilist.get(j).getText().toUpperCase();
            String itemorderPrice = prlist.get(j).getText();
            String itemdiscountPrice = prlist.get(j).getText();

            if (itemName.contains(name.toUpperCase()))
                found = found + 1;

            if (itemorderPrice.contains(orderPrice))
                found = found + 1;

            if (itemdiscountPrice.contains(discountPrice))
                found = found + 1;

            if (found == 3)
                check = true;
        }

        return check;
    }
}
