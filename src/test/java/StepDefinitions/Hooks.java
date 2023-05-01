package StepDefinitions;

import static org.testng.Assert.fail;
import org.openqa.selenium.WebDriver;
import com.shoppingonline.pom.POMCleanUp;
import com.utitlity.DriverLib;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;

public class Hooks {

    static DriverLib libDriver = new DriverLib();
    static WebDriver driver = libDriver.getWebDriver();

    @BeforeAll
    public static void beforeAll() {
        POMCleanUp pc = new POMCleanUp(driver);
        try {
            System.out.printf("-----------------------------------------------------------------------------------%n");
            System.out.printf("| %-55s |", "CLEANUP PROCESS BEFORE TEST SUITE");
            pc.login();
            pc.cleanUpWishlist();
            pc.cleanUpCart();
            pc.logout();
            System.out.printf(" %-7s |%-12s |%n", "", "SUCCESS");
        } catch (Exception e) {
            System.out.printf(" %-7s |%-12s |%n", "", "FAILURE");
            fail("failed in cleanup process before tests execution");
        }
        System.out.printf("-----------------------------------------------------------------------------------%n");
        System.out.printf("| %-12s | %-40s | %-7s |%-12s |%n", "TEST", "STEPS", "RESULT", "VALIDATION");
    }

    @After(order = 2, value = "@Wishlist or @Cart or @Order")
    public void cleanupWishlist() {
        try {
            POMCleanUp pc = new POMCleanUp(driver);
            System.out.printf("| %-12s | %-40s |", "", "CLEANUP WISHLIST");
            pc.cleanUpWishlist();
            System.out.printf(" %-7s |%-12s |%n", "PASS", "");
        } catch (Exception e) {
            System.out.printf(" %-7s |%-12s |%n", "FAIL", "");
        }
    }

    @After(order = 1, value = "@Cart or @Wishlist or @Order")
    public void logout() {
        try {
            System.out.printf("| %-12s | %-40s |", "", "LOGOUT");
            POMCleanUp pc = new POMCleanUp(driver);
            pc.logout();
            System.out.printf(" %-7s |%-12s |%n", "PASS", "");
            System.out.printf("-----------------------------------------------------------------------------------%n");
        } catch (Exception e) {
            System.out.printf(" %-7s |%-12s |%n", "FAIL", "");
            System.out.printf("-----------------------------------------------------------------------------------%n");
        }
    }

    @After(order = 2, value = "@Cart or @Order")
    public void cleanCart() {
        try {
            System.out.printf("| %-12s | %-40s |", "", "CLEANUP CART");
            POMCleanUp pc = new POMCleanUp(driver);
            pc.cleanUpCart();
            System.out.printf(" %-7s |%-12s |%n", "PASS", "");
        } catch (Exception e) {
            System.out.printf(" %-7s |%-12s |%n", "FAIL", "");
        }
    }
}