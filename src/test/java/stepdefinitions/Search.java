package stepdefinitions;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;

import com.shoppingonline.pom.POMNavbar;
import com.shoppingonline.pom.POMProductsPage;
import com.utitlity.DriverLib;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search {

    private final DriverLib driverLib = new DriverLib();
    private final WebDriver driver = driverLib.getWebDriver();

    private final POMNavbar pomNavbar = new POMNavbar(driver);
    private final POMProductsPage pomProductsPage = new POMProductsPage(driver);

    @Given("user is running search scenario")
    public void search_scenario() {
        System.out.printf("-----------------------------------------------------------------------------------%n");
        System.out.printf("| %-12s | %-42s  %-7s %-12s |%n", "SEARCH", "", "", "");
    }

    @When("user selects category as {string}")
    public void user_selects_category_as(String catog) {
        System.out.printf("| %-12s | %-40s |", "", "SELECT CATEGORY");

        try {
            Thread.sleep(2000);
            pomNavbar.selectCategory(catog);
            System.out.printf(" %-7s |%-12s |%n", "PASS", "");
        } catch (Exception e) {
            System.out.printf(" %-7s |%-12s |%n", "FAIL", "");
            fail("category could not be selected properly");
        }
    }

    @When("user enters the search item as {string}")
    public void user_enters_the_search_item_as(String item) {
        System.out.printf("| %-12s | %-40s |", "", "ENTER ITEM");

        try {
            Thread.sleep(2000);
            pomNavbar.enterItem(item);
            System.out.printf(" %-7s |%-12s |%n", "PASS", "");
        } catch (Exception e) {
            System.out.printf(" %-7s |%-12s |%n", "FAIL", "");
            fail("Item name could not be entered properly");
        }
    }

    @When("clicks on search button")
    public void clicks_on_search_button() {
        System.out.printf("| %-12s | %-40s |", "", "SEARCH ITEM");

        try {
            pomProductsPage.setProductShowRange();
            pomNavbar.clickOnSearchButton();
            System.out.printf(" %-7s |%-12s |%n", "PASS", "");
        } catch (Exception e) {
            System.out.printf(" %-7s |%-12s |%n", "FAIL", "");
            fail("Search button not clicked");
        }
    }

    @Then("user should be able to view the items {string}")
    public void user_should_be_able_to_view_the_items(String item) {
        boolean status = false;
        System.out.printf("| %-12s | %-40s |", "", "VALIDATE ON ITEM PAGE");

        try {
            status = pomProductsPage.validateSearch(item);
            System.out.printf(" %-7s |", "PASS");
        } catch (Exception e) {
            System.out.printf(" %-7s |", "FAIL");
            System.out.printf("%-12s |%n", "FAILURE");
            fail("Exception in Validating search Item");
        }

        if (status) {
            System.out.printf("%-12s |%n", "SUCCESS");
        } else {
            System.out.printf("%-12s |%n", "FAILURE");
            fail("The search items retrieved do not match for the item : " + item);
        }
    }

}
