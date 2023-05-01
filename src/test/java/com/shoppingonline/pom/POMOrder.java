package com.shoppingonline.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class POMOrder {

    WebDriver driver;

    public POMOrder(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnCheckout() throws Exception {
        Thread.sleep(2000);
        driver.findElement(POMElements.Cart_To_Checkout).click();
    }

    public void enterDetailsAndPlaceOrder(String fname, String email, String address, String city, String state,
                                          String zip, String name_on_card, String card_no, String expdate, String cvv) {

        driver.findElement(POMElements.Checkout_name).clear();
        driver.findElement(POMElements.Checkout_name).sendKeys(fname);
        driver.findElement(POMElements.Checkout_email).clear();
        driver.findElement(POMElements.Checkout_email).sendKeys(email);
        driver.findElement(POMElements.Checkout_address).clear();
        driver.findElement(POMElements.Checkout_address).sendKeys(address);
        driver.findElement(POMElements.Checkout_city).clear();
        driver.findElement(POMElements.Checkout_city).sendKeys(city);
        driver.findElement(POMElements.Checkout_state).clear();
        driver.findElement(POMElements.Checkout_state).sendKeys(state);
        driver.findElement(POMElements.Checkout_zip).clear();
        driver.findElement(POMElements.Checkout_zip).sendKeys(zip);
        driver.findElement(POMElements.Checkout_card_name).clear();
        driver.findElement(POMElements.Checkout_card_name).sendKeys(name_on_card);
        driver.findElement(POMElements.Checkout_card_number).clear();
        driver.findElement(POMElements.Checkout_card_number).sendKeys(card_no);
        driver.findElement(POMElements.Checkout_exp_date).clear();
        driver.findElement(POMElements.Checkout_exp_date).sendKeys(expdate);
        driver.findElement(POMElements.Checkout_cvv).clear();
        driver.findElement(POMElements.Checkout_cvv).sendKeys(cvv);
        driver.findElement(POMElements.Checkout_conform).click();
        driver.findElement(POMElements.Checkout_button).click();
    }

    public boolean checkOrderSuccessful() {
        return driver.getCurrentUrl().equalsIgnoreCase(POMElements.Order_successful_url);
    }

    public boolean validateOrder(String item1, String item2) throws Exception {
        driver.findElement(POMElements.Order_page).click();
        Thread.sleep(1000);
        List<WebElement> ilist = driver.findElements(POMElements.Order_Item_name);

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
