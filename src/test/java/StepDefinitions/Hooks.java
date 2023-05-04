package StepDefinitions;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;

import com.shoppingonline.pom.POMAccount;
import com.shoppingonline.pom.POMCart;
import com.shoppingonline.pom.POMLoginPage;
import com.shoppingonline.pom.POMNavbar;
import com.shoppingonline.pom.POMWishList;
import com.utitlity.DriverLib;

import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;

public class Hooks {

    static DriverLib libDriver = new DriverLib();
    static WebDriver driver = libDriver.getWebDriver();
    
    static POMAccount pomAccount = new POMAccount(driver);
    static POMNavbar pomNavbar = new POMNavbar(driver);
    static POMLoginPage pomLoginPage = new POMLoginPage(driver);
    static POMWishList pomWishList = new POMWishList(driver);
    static POMCart pomCart = new POMCart(driver);

    @BeforeAll
    public static void beforeAll() {
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
            pomNavbar.goToWishList();
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
            pomCart.cleanUpCart();
            System.out.printf(" %-7s |%-12s |%n", "PASS", "");
        } catch (Exception e) {
            System.out.printf(" %-7s |%-12s |%n", "FAIL", "");
        }
    }
}