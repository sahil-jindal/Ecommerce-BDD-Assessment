package com.shoppingonline.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class POMProductsPage {

	static final By Items_show_select = By.xpath("//*[@id='store']/div[1]/div/label[2]/select");
	static final By Item_name_list = By.xpath("//div[@id='get_product']//div[@class='product-body']/h3/a");
	static final By Item_price_list = By.xpath("//div[@id='get_product']//div[@class='product-body']/h4");
	static final By Item_category_list = By.xpath("//div[@id='get_product']//div[@class='product-body']/p");
	static final By Add_To_Wishlist = By.xpath("//*[@id='wishlist'][1]");

	WebDriver driver;

	public POMProductsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setProductShowRange() {
		new Select(driver.findElement(Items_show_select)).selectByVisibleText("50");
	}

	public boolean validateSearchItem(String name, String orderPrice, String discountPrice) {
		List<WebElement> ilist = driver.findElements(Item_name_list);
		List<WebElement> prlist = driver.findElements(Item_price_list);

		for (int j = 0; j < ilist.size(); j++) {
			String itemName = ilist.get(j).getText().toUpperCase();
			String itemorderPrice = prlist.get(j).getText();
			String itemdiscountPrice = prlist.get(j).getText();

			if (itemName.contains(name.toUpperCase()) && 
				itemorderPrice.contains(orderPrice) && 
				itemdiscountPrice.contains(discountPrice)) return true;
		}

		return false;
	}

	public boolean validateSearch(String item) {
		List<WebElement> ilist = driver.findElements(Item_name_list);

		if (ilist.size() == 0)
			return false;

		for (WebElement webElement : ilist) {
			if (!webElement.getText().contains(item.toUpperCase())) {
				return false;
			}
		}

		return true;
	}

	public String addToWishlist() {
		String item = driver.findElements(Item_name_list).get(0).getText();
		driver.findElement(Add_To_Wishlist).click();
		return item;
	}

	public boolean validateSearchItem(String count) {
		List<WebElement> ilist = driver.findElements(Item_category_list);
		return Integer.parseInt(count) == ilist.size();
	}
}
