package StepDefinitions;

import static org.testng.Assert.fail;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.shoppingonline.pom.POMAccount;
import com.shoppingonline.pom.POMCategories;
import com.shoppingonline.pom.POMLoginPage;
import com.utitlity.DriverLib;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonSteps {

	private final DriverLib driverLib = new DriverLib();
	private final WebDriver driver = driverLib.getWebDriver();

	private final POMAccount pomAccount = new POMAccount(driver);
	private final POMLoginPage pomLoginPage = new POMLoginPage(driver);
	private final POMCategories pomCategories = new POMCategories(driver);

	@Given("user is on homepage")
	public void user_is_on_homepage() {
		System.out.printf("| %-12s | %-40s |", "", "HOMEPAGE");
		
		try {
			pomAccount.checkHomePage();
			System.out.printf(" %-7s |%-12s |%n", "PASS", "");
		} catch (NoSuchElementException e) {
			System.out.printf(" %-7s |%-12s |%n", "FAIL", "");
			fail("Exception in reaching home page");
		}
	}

	@When("user clicks on menu bar item")
	public void user_clicks_on_menu_bar_item() {
		System.out.printf("| %-12s | %-40s |", "", "MENU BAR ITEM");
		
		try {
			pomCategories.clickOnHeaderMenu();
			System.out.printf(" %-7s |%-12s |%n", "PASS", "");
		} catch (NoSuchElementException e) {
			System.out.printf(" %-7s |%-12s |%n", "FAIL", "");
			fail("Menu bar item not clicked");
		}
	}

	@Given("user is logged in and at the homepage")
	public void user_is_logged_in_and_at_the_homepage() {
		System.out.printf("| %-12s | %-40s |", "", "LOGIN");
		
		try {
			pomAccount.goToLoginPage();
			pomLoginPage.login();
			pomAccount.checkHomePage();
			System.out.printf(" %-7s |%-12s |%n", "PASS", "");
		} catch (Exception e) {
			System.out.printf(" %-7s |%-12s |%n", "FAIL", "");
			fail("user unable to login properly");
		}
	}
}
