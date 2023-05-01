package com.shoppingonline.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class POMLeftMenu {

    WebDriver driver;

    public POMLeftMenu(WebDriver driver) {
        this.driver = driver;
    }

    public String selectItem(String item) {
        new Select(driver.findElement(POMElements.Items_show_select)).selectByVisibleText("50");
        driver.findElement(By.partialLinkText(item + POMElements.Aside_category2)).click();
        String str = driver.findElement(By.partialLinkText(item + POMElements.Aside_category2)).getText();
        // Replace "Something" with meaningful word
        String[] something = str.split(" ");
        int n = something.length;
        String str1 = something[n - 1];
        return str1.substring(1, str1.length() - 1);
    }

    public boolean validateSearchItem(String count) {
        List<WebElement> ilist = driver.findElements(POMElements.Item_category_list);
        return Integer.parseInt(count) == ilist.size();
    }
}
