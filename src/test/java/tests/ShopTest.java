package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class ShopTest extends BaseTest {

    private static final String VALID_USER = "standard_user";
    private static final String VALID_PASS = "secret_sauce";

    @Test(description = "Valid login lands on the Products page")
    public void testValidLogin() {
        LoginPage login = new LoginPage(driver);
        login.load();
        login.login(VALID_USER, VALID_PASS);

        InventoryPage inventory = new InventoryPage(driver);
        Assert.assertEquals(inventory.getTitle(), "Products");
    }

    @Test(description = "Locked-out user sees an error message")
    public void testInvalidLogin() {
        LoginPage login = new LoginPage(driver);
        login.load();
        login.login("locked_out_user", VALID_PASS);

        Assert.assertTrue(login.getError().toLowerCase().contains("locked out"));
    }

    @Test(description = "Empty fields show 'Username is required'")
    public void testEmptyCredentials() {
        LoginPage login = new LoginPage(driver);
        login.load();
        login.login("", "");

        Assert.assertTrue(
                login.getError().toLowerCase().contains("username is required"));
    }

    @Test(description = "Add item to cart -> cart count becomes 1")
    public void testAddItemToCart() {
        LoginPage login = new LoginPage(driver);
        login.load();
        login.login(VALID_USER, VALID_PASS);

        InventoryPage inventory = new InventoryPage(driver);
        inventory.addBackpackToCart();

        Assert.assertEquals(inventory.getCartCount(), "1");
    }
}
