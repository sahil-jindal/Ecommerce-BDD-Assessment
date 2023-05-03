package StepDefinitions;

import static org.testng.Assert.fail;

import com.shoppingonline.pom.POMAccount;
import com.shoppingonline.pom.POMCart;
import com.shoppingonline.pom.POMLoginPage;
import com.shoppingonline.pom.POMNavbar;
import com.shoppingonline.pom.POMWishList;

import org.openqa.selenium.WebDriver;
import com.utitlity.DriverLib;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;

public class Hooks {

    static DriverLib libDriver = new DriverLib();
    static WebDriver driver = libDriver.getWebDriver();

    @BeforeAll
    public static void beforeAll() {
        POMAccount pomAccount = new POMAccount(driver);
        POMNavbar pomNavbar = new POMNavbar(driver);
        POMLoginPage pomLoginPage = new POMLoginPage(driver);
        POMWishList pomWishList = new POMWishList(driver);
        POMCart pomCart = new POMCart(driver);

        try {
            System.out.printf("-----------------------------------------------------------------------------------%n");
            System.out.printf("| %-55s |", "CLEANUP PROCESS BEFORE TEST SUITE");
            pomAccount.goToLoginPage();
            pomLoginPage.login();
            pomNavbar.goToWishList();
            pomWishList.cleanUpWishlist();
            pomNavbar.goToEditCart();
            pomCart.cleanUpCart();
            pomAccount.logout();
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
            System.out.printf("| %-12s | %-40s |", "", "CLEANUP WISHLIST");
            POMNavbar pomNavbar = new POMNavbar(driver);
            pomNavbar.goToWishList();
            POMWishList pomWishList = new POMWishList(driver);
            pomWishList.cleanUpWishlist();
            System.out.printf(" %-7s |%-12s |%n", "PASS", "");
        } catch (Exception e) {
            System.out.printf(" %-7s |%-12s |%n", "FAIL", "");
        }
    }

    @After(order = 1, value = "@Cart or @Wishlist or @Order")
    public void logout() {
        try {
            System.out.printf("| %-12s | %-40s |", "", "LOGOUT");
            POMAccount pomAccount = new POMAccount(driver);
            pomAccount.logout();
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
            POMCart pomCart = new POMCart(driver);
            pomCart.cleanUpCart();
            System.out.printf(" %-7s |%-12s |%n", "PASS", "");
        } catch (Exception e) {
            System.out.printf(" %-7s |%-12s |%n", "FAIL", "");
        }
    }
}