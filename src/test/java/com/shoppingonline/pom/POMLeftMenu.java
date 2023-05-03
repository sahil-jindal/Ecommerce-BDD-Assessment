package com.shoppingonline.pom;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class POMLeftMenu {

    static final String Aside_category2 = " (";

    WebDriver driver;

    public POMLeftMenu(WebDriver driver) {
        this.driver = driver;
    }

    public String selectCategory(String item) {
        WebElement category = driver.findElement(By.partialLinkText(item + Aside_category2));
        category.click();

        String categoryText = category.getText();
        Matcher matcher = Pattern.compile("\\((\\d+)\\)").matcher(categoryText);

        if (!matcher.find())
            return "0";

        return matcher.group(1);
    }
}
