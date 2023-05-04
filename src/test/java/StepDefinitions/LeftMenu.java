package StepDefinitions;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;

import com.shoppingonline.pom.POMLeftMenu;
import com.shoppingonline.pom.POMProductsPage;
import com.utitlity.DriverLib;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LeftMenu {

    private final DriverLib LibDriver = new DriverLib();
    private final WebDriver driver = LibDriver.getWebDriver();

    private final POMLeftMenu pomLeftMenu = new POMLeftMenu(driver);
    private final POMProductsPage pomProductsPage = new POMProductsPage(driver);

    private String Count = "";
    private String Item = "";

    @Given("user is running Left Menu functionality scenario")
    public void left_menu_functionality() {
        System.out.printf("-----------------------------------------------------------------------------------%n");
        System.out.printf("| %-12s | %-42s  %-7s %-12s |%n", "LEFT MENU", "", "", "");
    }

    @When("user clicks on left menu item {string}")
    public void user_clicks_on_left_menu_item(String item) {
        System.out.printf("| %-12s | %-40s |", "", "SELECT LEFT MENU CATEGORY");
        try {
            Item = item;
            pomProductsPage.setProductShowRange();
            Count = pomLeftMenu.selectCategory(Item);
            System.out.printf(" %-7s |%-12s |%n", "PASS", "");
        } catch (Exception e) {
            System.out.printf(" %-7s |%-12s |%n", "FAIL", "");
            fail("Left menu category not selected");
        }
    }

    @Then("The count of the category should match with no. of items displayed")
    public void the_count_of_the_category_should_match_with_no_of_items_displayed() {
        boolean status = false;
        System.out.printf("| %-12s | %-40s |", "", "VALIDATE COUNT ON ITEM PAGE");

        try {
            status = pomProductsPage.validateSearchItem(Count);
            System.out.printf(" %-7s |", "PASS");
        } catch (Exception e) {
            System.out.printf(" %-7s |", "FAIL");
            System.out.printf("%-12s |%n", "FAILURE");
            e.printStackTrace();
            fail("Exception in validating Item page for left menu");
        }

        if (status) {
            System.out.printf("%-12s |%n", "SUCCESS");
        } else {
            System.out.printf("%-12s |%n", "FAILURE");
            fail("The count of the items retrieved does not match for category: " + Item);
        }
    }
}
