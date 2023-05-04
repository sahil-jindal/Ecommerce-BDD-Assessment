package com.shoppingonline.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class POMOrder {

	static final By Cart_To_Checkout = By.xpath("//*[@id='submit']");
	static final By Checkout_name = By.xpath("//*[@id='fname']");
	static final By Checkout_email = By.xpath("//*[@id='email']");
	static final By Checkout_address = By.xpath("//*[@id='adr']");
	static final By Checkout_city = By.xpath("//*[@id='city']");
	static final By Checkout_state = By.xpath("//*[@id='state']");
	static final By Checkout_zip = By.xpath("//*[@id='zip']");
	static final By Checkout_card_name = By.xpath("//*[@id='cname']");
	static final By Checkout_card_number = By.xpath("//*[@id='cardNumber']");
	static final By Checkout_exp_date = By.xpath("//*[@id='expdate']");
	static final By Checkout_cvv = By.xpath("//*[@id='cvv']");
	static final By Checkout_conform = By.xpath("//*[@id='checkout_form']/label/input");
	static final By Checkout_button = By.xpath("//*[@id='submit']");
	static final By Confirm_Order_button = By.xpath("/html/body/div/div[2]/a[2]");
	static final String Order_successful_url = "http://localhost/shoppingonline/order_successful.php";
	static final By Order_page = By.xpath("/html/body/div/div[2]/a[2]");
	static final By Order_Item_name = By.xpath("//div[@class='cart'][1]//h3");

	WebDriver driver;

	public POMOrder(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnCheckout() throws Exception {
		Thread.sleep(2000);
		driver.findElement(Cart_To_Checkout).click();
	}

	public void enterDetailsAndPlaceOrder(String fname, String email, String address, String city, String state,
			String zip, String name_on_card, String card_no, String expdate, String cvv) {

		driver.findElement(Checkout_name).clear();
		driver.findElement(Checkout_name).sendKeys(fname);
		driver.findElement(Checkout_email).clear();
		driver.findElement(Checkout_email).sendKeys(email);
		driver.findElement(Checkout_address).clear();
		driver.findElement(Checkout_address).sendKeys(address);
		driver.findElement(Checkout_city).clear();
		driver.findElement(Checkout_city).sendKeys(city);
		driver.findElement(Checkout_state).clear();
		driver.findElement(Checkout_state).sendKeys(state);
		driver.findElement(Checkout_zip).clear();
		driver.findElement(Checkout_zip).sendKeys(zip);
		driver.findElement(Checkout_card_name).clear();
		driver.findElement(Checkout_card_name).sendKeys(name_on_card);
		driver.findElement(Checkout_card_number).clear();
		driver.findElement(Checkout_card_number).sendKeys(card_no);
		driver.findElement(Checkout_exp_date).clear();
		driver.findElement(Checkout_exp_date).sendKeys(expdate);
		driver.findElement(Checkout_cvv).clear();
		driver.findElement(Checkout_cvv).sendKeys(cvv);
		driver.findElement(Checkout_conform).click();
		driver.findElement(Checkout_button).click();
	}

	public boolean checkOrderSuccessful() {
		return driver.getCurrentUrl().equalsIgnoreCase(Order_successful_url);
	}

	public boolean validateOrder(String item1, String item2) throws Exception {
		driver.findElement(Order_page).click();
		Thread.sleep(1000);

		List<WebElement> ilist = driver.findElements(Order_Item_name);

		int count = 0;

		for (WebElement webElement : ilist) {
			String itemName = webElement.getText().toUpperCase();
			if (itemName.contains(item1.toUpperCase()) || itemName.contains(item2.toUpperCase())) {
				count = count + 1;
			}
		}

		return count == 2;
	}
}
