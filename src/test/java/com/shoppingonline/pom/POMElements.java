package com.shoppingonline.pom;

import java.util.HashMap;

import org.openqa.selenium.By;

public class POMElements {

    //Site URL
    public static final String URL = "http://localhost/shoppingonline";

    //Login credentials
    static final String user_email = "otheruser@gmail.com";
    static final String user_password = "support";

    //Login
    static final By Account_name = By.xpath("//*[@id='top-header']/div/ul[2]/li[2]/div/a");
    static final By Account_to_login = By.xpath("//*[@id=\"top-header\"]/div/ul[2]/li[2]/div/div/a[2]");
    static final By Login_Email = By.xpath("//*[@id='login']/div[1]/input");
    static final By Login_Password = By.xpath("//*[@id='login']/div[2]/input");
    static final By Login_Button = By.xpath("//*[@id='login']/div[4]/div/button");

    //Logout
    static final By Account_to_logout = By.xpath("//*[@id=\"top-header\"]/div/ul[2]/li[2]/div/div/a[3]");

    //Search
    static final By FurnitureHeader = By.xpath("//a[contains(text(),'Furnitures')]");
    static final By SelectCategory = By.xpath("//div[@class='header-search']//select[@class='input-select']");
    static final By SearchItem = By.xpath("//input[@id='search']");
    static final By SearchButton = By.xpath("//button[@id='search_btn']");
    static final By Items_show_select = By.xpath("//*[@id='store']/div[1]/div/label[2]/select");
    static final By Item_name_list = By.xpath("//div[@id='get_product']//div[@class='product-body']/h3/a");

    //Header menu
    static final By Item_price_list = By.xpath("//div[@id='get_product']//div[@class='product-body']/h4");
    static final By Item_category_list = By.xpath("//div[@id='get_product']//div[@class='product-body']/p");
    static final String Header_category1 = "//a[contains(text(),'";
    static final String Header_category2 = "')]";

    //Left menu
    static final String Aside_category2 = " (";

    //Wish list
    static final By Add_To_Wishlist = By.xpath("//*[@id='wishlist'][1]");
    static final By Go_To_Wishlist = By.xpath("//*[@id='header']/div/div/div[3]/div/div[1]/a");
    static final By Item_name_Wishlist = By.xpath("//*[@id='wishlist']/tbody/tr/td[1]/div/div[1]/h4/a");
    static final String Trash_Wishlist1 = "//*[@id='wishlist']/tbody/tr/td[1]/div/div[1]/h4/a[contains(text(),'";
    static final String Trash_Wishlist2 = "')]/ancestor::tr/td[4]/div/a/i";
    static final By WishList_To_Cart = By.xpath("//*[@id='product']");

    //Cart
    static final By Go_To_Cart = By.xpath("//*[@id='header']/div/div/div[3]/div/div[2]/a");
    static final By Go_To_Cart_Edit_Button = By.xpath("//*[@id='header']/div/div/div[3]/div/div[2]/div/div[2]/a");
    static final String Cart_Quantity1 = "//*[@id='cart']/tbody/tr[";
    static final String Cart_Quantity2 = "]/td[3]/input";
    static final By Cart_Item_name = By.xpath("//*[@id='cart']/tbody/tr/td[1]/div/div[1]/h4/a");
    static final String Cart_Item_Price1 = "//*[@id='cart']/tbody/tr[";
    static final String Cart_Item_Price2 = "]/td[2]/input";
    static final By Cart_Total = By.xpath("//*[@id='cart']/tfoot/tr/td[3]/b");

    //Order
    static final By Cart_To_Checkout = By.xpath("//*[@id='submit']");
    static final By Checkout_name = By.xpath("//*[@id='fname']");
    static final By Checkout_email = By.xpath("//*[@id='email']");
    static final By Checkout_address = By.xpath("//*[@id='adr']");
    static final By Checkout_city = By.xpath("//*[@id='city']");
    static final By Checkout_state = By.xpath("//*[@id='state']");
    static final By Checkout_zip = By.xpath("//*[@id='zip']");
    static final By Checkout_card_name = By.xpath("//*[@id='cname']");
    static final By Checkout_card_number = By.xpath("//*[@id='cardNumber']");
    static final By Checkout_exp_date = By.xpath("//*[@id='expdate']");
    static final By Checkout_cvv = By.xpath("//*[@id='cvv']");
    static final By Checkout_conform = By.xpath("//*[@id='checkout_form']/label/input");
    static final By Checkout_button = By.xpath("//*[@id='submit']");
    static final By Confirm_Order_button = By.xpath("/html/body/div/div[2]/a[2]");
    static final String Order_successful_url = "http://localhost/shoppingonline/order_successful.php";
    static final By Order_page = By.xpath("/html/body/div/div[2]/a[2]");
    static final By Order_Item_name = By.xpath("//div[@class='cart'][1]//h3");

    //Cleanup
    static final By Trash_Wishlist = By.xpath("//*[@id='wishlist']/tbody/tr/td[4]//a");
    static final By Trash_Cart = By.xpath("//*[@id='cart']/tbody/tr/td[5]/div/a[2]");

    //menu url check hashmap
    public static final HashMap<String, Integer> urlMap = new HashMap<>();

    static {
        urlMap.put("Electronics", 1);
        urlMap.put("Kids Wear", 4);
        urlMap.put("Furnitures", 5);
        urlMap.put("Home Appliances", 6);
        urlMap.put("Electronics Gadgets", 7);
    }

}
