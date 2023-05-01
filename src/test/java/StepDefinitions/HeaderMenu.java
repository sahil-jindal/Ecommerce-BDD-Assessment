package StepDefinitions;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;
import com.shoppingonline.pom.POMHeaderMenu;
import com.utitlity.DriverLib;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HeaderMenu {

    private final DriverLib driverLib = new DriverLib();
    private final WebDriver driver = driverLib.getWebDriver();
    private final POMHeaderMenu hm = new POMHeaderMenu(driver);
    private String Item = "";

    @Given("user is running menu functionality scenario")
    public void header_menu_functionality() {
        System.out.printf("-----------------------------------------------------------------------------------%n");
        System.out.printf("| %-12s | %-42s  %-7s %-12s |%n", "HEADER MENU", "", "", "");
    }

    @When("user clicks on menu bar item {string}")
    public void user_clicks_on_menu_bar_item(String item) {
        System.out.printf("| %-12s | %-40s |", "", "SELECT HEADER CATEGORY");
        try {
            hm.selectItem(item);
            Item = item;
            System.out.printf(" %-7s |%-12s |%n", "PASS", "");
        } catch (Exception e) {
            System.out.printf(" %-7s |%-12s |%n", "FAIL", "");
            fail("Header Category not selected");
        }
    }

    @Then("user should be able to navigate to the item page")
    public void user_should_be_able_to_navigate_to_the_item_page() {
        boolean status = false;
        System.out.printf("| %-12s | %-40s |", "", "VALIDATE ON ITEM PAGE");

        try {
            status = hm.validateURL(Item);
            System.out.printf(" %-7s |", "PASS");
        } catch (Exception e) {
            System.out.printf(" %-7s |", "FAIL");
            System.out.printf("%-12s |%n", "FAILURE");
            fail("Exception in Validating Items");
        }
        if (status) {
            System.out.printf("%-12s |%n", "SUCCESS");
        } else {
            System.out.printf("%-12s |%n", "FAILURE");
            fail("The category of the items retrieved do not match for category");
        }
    }

    @Then("validate the product present with {string} and {string} and {string}")
    public void validate_the_product_present_with_and_and(String name, String oprice, String dprice) {
        boolean status = false;
        System.out.printf("| %-12s | %-40s |", "", "VALIDATE PRODUCT");

        try {
            status = hm.validateSearchItem(name, oprice, dprice);
            System.out.printf(" %-7s |", "PASS");
        } catch (Exception e) {
            System.out.printf(" %-7s |", "FAIL");
            System.out.printf("%-12s |%n", "FAILURE");
            fail("Exception in Validating product");
        }
        if (status) {
            System.out.printf("%-12s |%n", "SUCCESS");
        } else {
            System.out.printf("%-12s |%n", "FAILURE");
            fail("The product " + name + " given does not exist in category " + Item);
        }
    }

}
