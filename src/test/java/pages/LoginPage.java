package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents the login screen of https://www.saucedemo.com
 * Locators (how we FIND elements) live here, separate from the tests.
 * If the site's HTML changes, we fix it in ONE place, not in every test.
 */
public class LoginPage extends BasePage {

    public static final String URL = "https://www.saucedemo.com/";

    // --- Locators ---
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton   = By.id("login-button");
    private final By errorMessage  = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void load() {
        driver.get(URL);
    }

    public void login(String username, String password) {
        type(usernameInput, username);
        type(passwordInput, password);
        click(loginButton);
    }

    public String getError() {
        return getText(errorMessage);
    }
}
