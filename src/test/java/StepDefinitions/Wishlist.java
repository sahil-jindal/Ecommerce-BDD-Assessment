package StepDefinitions;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;

import com.shoppingonline.pom.POMNavbar;
import com.shoppingonline.pom.POMProductsPage;
import com.shoppingonline.pom.POMWishList;
import com.utitlity.DriverLib;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Wishlist {

	private final DriverLib driverLib = new DriverLib();
	private final WebDriver driver = driverLib.getWebDriver();

	private final POMWishList wl = new POMWishList(driver);
	private final POMNavbar pomNavbar = new POMNavbar(driver);
	private final POMProductsPage pomProductsPage = new POMProductsPage(driver);

	public static String Item1 = "";
	public static String Item2 = "";
	static int itemcount = 0;

	@Given("user is running Wishlist scenario")
	public void wishlist_scenario() {
		System.out.printf("-----------------------------------------------------------------------------------%n");
		System.out.printf("| %-12s | %-42s  %-7s %-12s |%n", "WISHLIST", "", "", "");
	}

	@When("user will add to wishlist")
	public void user_will_add_to_wishlist() {
		System.out.printf("| %-12s | %-40s |", "", "ADD TO WISHLIST");

		try {
			Item1 = pomProductsPage.addToWishlist();
			++itemcount;
			Item2 = pomProductsPage.addToWishlist();
			++itemcount;
			System.out.printf(" %-7s |%-12s |%n", "PASS", "");
		} catch (Exception e) {
			System.out.printf(" %-7s |%-12s |%n", "FAIL", "");
			fail("Exception in adding to wishlist");
		}
	}

	@Then("validate the items in wishlist")
	public void validate_the_items_in_wishlist() {
		boolean status = false;
		System.out.printf("| %-12s | %-40s |", "", "VALIDATE ON WISHLIST");

		try {
			pomNavbar.goToWishList();
			status = wl.validateWishlist(Item1, Item2);
			System.out.printf(" %-7s |", "PASS");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.printf(" %-7s |", "FAIL");
			System.out.printf("%-12s |%n", "FAILURE");
			fail("Exception in validating wishlist item");
		}

		if (status) {
			System.out.printf("%-12s |%n", "SUCCESS");
		} else {
			System.out.printf("%-12s |%n", "FAILURE");
			fail("The items added to wishlist do not match in wishlist ");
		}
	}

	@Then("user removes the item {string} from wishlist")
	public void user_removes_the_item_from_wishlist(String item1) {
		System.out.printf("| %-12s | %-40s |", "", "UPDATE IN WISHLIST");

		try {
			wl.removeFromWishlist(item1);
			System.out.printf(" %-7s |%-12s |%n", "PASS", "");
		} catch (Exception e) {
			System.out.printf(" %-7s |%-12s |%n", "FAIL", "");
			fail("Exception in updating wishlist");
		}
	}

	@Then("validate the removed product")
	public void validate_the_removed_product() {
		boolean status = false;
		System.out.printf("| %-12s | %-40s |", "", "VALIDATE UPDATE IN WISHLIST");

		try {
			pomNavbar.goToWishList();
			status = wl.validateWishlist(Item2);
			System.out.printf(" %-7s |", "PASS");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.printf(" %-7s |", "FAIL");
			System.out.printf("%-12s |%n", "FAILURE");
			fail("Exception in validating updated wishlist");
		}

		if (status) {
			System.out.printf("%-12s |%n", "SUCCESS");
		} else {
			System.out.printf("%-12s |%n", "FAILURE");
			fail("Validation in wishlist after update failed");
		}
	}
}