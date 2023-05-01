package com.shoppingonline.pom;

import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class POMSearchItem {

    WebDriver driver;

    public POMSearchItem(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnHeaderMenu() throws NoSuchElementException {
        driver.findElement(POMElements.FurnitureHeader).click();
    }

    public void selectCategory(String catog) throws NoSuchElementException {
        new Select(driver.findElement(POMElements.SelectCategory)).selectByVisibleText(catog);
    }

    public void enterItem(String item) throws Exception {
        driver.findElement(POMElements.SearchItem).clear();
        driver.findElement(POMElements.SearchItem).sendKeys(item);
        Thread.sleep(1000);
    }

    public void clickOnSearchButton() throws NoSuchElementException {
        new Select(driver.findElement(POMElements.Items_show_select)).selectByVisibleText("50");
        driver.findElement(POMElements.SearchButton).click();
    }

    public boolean validateSearch(String item) {
        List<WebElement> ilist = driver.findElements(POMElements.Item_name_list);

		if (ilist.size() == 0) return false;

		for (WebElement webElement : ilist) {
			if (!webElement.getText().contains(item.toUpperCase())) {
				return false;
			}
		}

        return true;
    }
}
