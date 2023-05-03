package StepDefinitions;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;

import com.shoppingonline.pom.POMCart;
import com.shoppingonline.pom.POMNavbar;
import com.shoppingonline.pom.POMWishList;
import com.utitlity.DriverLib;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Cart {
	private final DriverLib libDriver = new DriverLib();
	private final WebDriver driver = libDriver.getWebDriver();

	private final POMCart sc = new POMCart(driver);
	private final POMNavbar pomNavbar = new POMNavbar(driver);
	private final POMWishList pomWishList = new POMWishList(driver);

	public static String item1price = "";
	public static String item2price = "";
	public static int count = 0;
	static String finaltotal = "";

	@Given("user is running Cart scenario")
	public void cart_scenario() {
		System.out.printf("-----------------------------------------------------------------------------------%n");
		System.out.printf("| %-12s | %-42s  %-7s %-12s |%n", "CART", "", "", "");
	}

	@When("user is on wishlist")
	public void user_is_on_wishlist() {
		System.out.printf("| %-12s | %-40s |", "", "GO TO WISHLIST");
		
		try {
			pomNavbar.goToWishList();
			System.out.printf(" %-7s |%-12s |%n", "PASS", "");
		} catch (Exception e) {
			System.out.printf(" %-7s |%-12s |%n", "FAIL", "");
			fail("user unable to go to wishlist");
		}
	}

	@When("user clicks on move to cart")
	public void user_clicks_on_move_to_cart() {
		System.out.printf("| %-12s | %-40s |", "", "MOVE TO CART");
		
		try {
			pomWishList.WishListToCart();
			System.out.printf(" %-7s |%-12s |%n", "PASS", "");
		} catch (Exception e) {
			System.out.printf(" %-7s |%-12s |%n", "FAIL", "");
			fail("items move to cart failed");
		}
	}

	@Then("user clicks on edit cart button")
	public void user_clicks_on_edit_cart_button() {
		System.out.printf("| %-12s | %-40s |", "", "CLICK EDIT CART");
		
		try {
			pomNavbar.goToEditCart();
			System.out.printf(" %-7s |%-12s |%n", "PASS", "");
		} catch (Exception e) {
			System.out.printf(" %-7s |%-12s |%n", "FAIL", "");
			fail("unable to go to cart");
		}
	}

	@Then("validate the items in cart")
	public void validate_the_items_in_cart() {
		boolean status = false;
		System.out.printf("| %-12s | %-40s |", "", "VALIDATE ON CART");
		
		try {
			status = sc.validateCart(Wishlist.Item1, Wishlist.Item2);
			System.out.printf(" %-7s |", "PASS");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.printf(" %-7s |", "FAIL");
			System.out.printf("%-12s |%n", "FAILURE");
			fail("Exception in validate cart");
		}
		
		if (status) {
			System.out.printf("%-12s |%n", "SUCCESS");
		} else {
			System.out.printf("%-12s |%n", "FAILURE");
			fail("The names of the items retrieved do not match in Cart ");
		}
	}

	@Then("user update the quantity as {string} {string}")
	public void user_update_the_quantity_as(String quantity1, String quantity2) {
		System.out.printf("| %-12s | %-40s |", "", "UPDATE THE CART");
		
		try {
			sc.updateCart(quantity1, quantity2);
			int item1product = Integer.parseInt(item1price) * Integer.parseInt(quantity1);
			int item2product = Integer.parseInt(item2price) * Integer.parseInt(quantity2);
			int finalTotal = item1product + item2product;
			finaltotal = Integer.toString(finalTotal);
			System.out.printf(" %-7s |%-12s |%n", "PASS", "");
		} catch (Exception e) {
			System.out.printf(" %-7s |%-12s |%n", "FAIL", "");
			fail("user unable to update properly");
		}
	}

	@Then("validate the updation")
	public void validate_the_updation() {
		boolean status = false;
		System.out.printf("| %-12s | %-40s |", "", "VALIDATE UPDATE ON CART");
		
		try {
			status = sc.validateUpdateCart(finaltotal);
			System.out.printf(" %-7s |", "PASS");
		} catch (Exception e) {
			System.out.printf(" %-7s |", "FAIL");
			System.out.printf("%-12s |%n", "FAILURE");
			fail("Exception in validating cart after update");
		}
		
		if (status) {
			System.out.printf("%-12s |%n", "SUCCESS");
		} else {
			System.out.printf("%-12s |%n", "FAILURE");
			fail("The validation after updation in cart not successful");
		}
	}
}
