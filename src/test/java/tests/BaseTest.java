package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

/**
 * BaseTest creates a fresh Chrome browser before EACH test (@BeforeMethod)
 * and closes it after (@AfterMethod). Every test class extends this, so the
 * browser setup is written once and reused.
 */
public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // WebDriverManager downloads the matching chromedriver automatically.
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        // --- HEADLESS toggle ---
        // SEES the browser open and click things.
        //options.addArguments("--headless=new");

        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();   // always close the browser
        }
    }
}
