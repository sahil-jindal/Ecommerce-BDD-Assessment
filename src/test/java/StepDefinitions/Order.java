package StepDefinitions;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;

import com.shoppingonline.pom.POMOrder;
import com.utitlity.DriverLib;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Order {

    private final DriverLib driverLib = new DriverLib();
    
    private final WebDriver driver = driverLib.getWebDriver();
    private final POMOrder oc = new POMOrder(driver);

    @Given("user is running  Order scenario")
    public void order_scenario() {
        System.out.printf("-----------------------------------------------------------------------------------%n");
        System.out.printf("| %-12s | %-42s  %-7s %-12s |%n", "ORDER", "", "", "");
    }

    @When("user clicks on checkout button")
    public void user_clicks_on_checkout_button() {
        System.out.printf("| %-12s | %-40s |", "", "CHECKOUT FROM CART");
        
        try {
            oc.clickOnCheckout();
            System.out.printf(" %-7s |%-12s |%n", "PASS", "");
        } catch (Exception e) {
            System.out.printf(" %-7s |%-12s |%n", "FAIL", "");
            fail("user unable to checkout from cart");
        }
    }

    @When("user will fill the card details as {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void user_will_fill_the_card_details_as(String fname, String email, String address, String city, 
    		String state, String zip, String name_on_card, String card_no, String expdate, String cvv) {
        
    	System.out.printf("| %-12s | %-40s |", "", "PLACE THE ORDER");
        
    	try {
            oc.enterDetailsAndPlaceOrder(fname, email, address, city, state, zip, name_on_card, card_no, expdate, cvv);
            System.out.printf(" %-7s |%-12s |%n", "PASS", "");
        } catch (Exception e) {
            System.out.printf(" %-7s |%-12s |%n", "FAIL", "");
            fail("user not enter details in checkout page");
        }
    }

    @When("user successfully places the order")
    public void user_will_buy_the_product() {
        boolean status = false;
        System.out.printf("| %-12s | %-40s |", "", "VALIDATE PLACE ORDER");
        
        try {
            status = oc.checkOrderSuccessful();
            System.out.printf(" %-7s |", "PASS");
        } catch (Exception e) {
            System.out.printf(" %-7s |", "FAIL");
            System.out.printf("%-12s |%n", "FAILURE");
            fail("Exception in validating place order");
        }
        
        if (status) {
            System.out.printf("%-12s |%n", "SUCCESS");
        } else {
            System.out.printf("%-12s |%n", "FAILURE");
            fail("The order successful page not reached");
        }
    }

    @When("validate the order")
    public void validate_the_order() {
        boolean status = false;
        System.out.printf("| %-12s | %-40s |", "", "VALIDATE ON ORDER PAGE");

		try {
            status = oc.validateOrder(Wishlist.Item1, Wishlist.Item2);
            System.out.printf(" %-7s |", "PASS");
        } catch (Exception e) {
            System.out.printf(" %-7s |", "FAIL");
            System.out.printf("%-12s |%n", "FAILURE");
            fail("Exception in validating order details");
        }

        if (status) {
            System.out.printf("%-12s |%n", "SUCCESS");
        } else {
            System.out.printf("%-12s |%n", "FAILURE");
            fail("The names of the items ordered do not match in order page ");
        }
    }
}
