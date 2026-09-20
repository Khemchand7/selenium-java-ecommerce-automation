package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The products page shown AFTER a successful login. Handles adding items to
 * the cart and reading the cart badge count.
 */
public class InventoryPage extends BasePage {

    private final By title       = By.className("title");                    // "Products" heading
    private final By addBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartBadge   = By.className("shopping_cart_badge");      // red count bubble
    private final By cartLink    = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return getText(title);
    }

    public void addBackpackToCart() {
        click(addBackpack);
    }

    public String getCartCount() {
        if (isVisible(cartBadge)) {
            return getText(cartBadge);
        }
        return "0";
    }

    public void openCart() {
        click(cartLink);
    }
}
