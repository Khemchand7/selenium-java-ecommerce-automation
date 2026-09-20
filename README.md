# Selenium E-Commerce Automation (Java + TestNG + Maven)

Automated UI + functional tests for an e-commerce login and cart flow, using
the **Page Object Model (POM)** design pattern. Target site:
[saucedemo.com](https://www.saucedemo.com) — a public site made for practising
Selenium.

## What it tests
| # | Test | Type |
|---|------|------|
| 1 | Valid login lands on the Products page | Positive |
| 2 | Locked-out user sees an error | Negative |
| 3 | Empty username/password shows "Username is required" | Negative |
| 4 | Add item to cart → cart count becomes 1 | End-to-end |

## Project structure
```
selenium-java/
├── pom.xml                       # Maven config + dependencies
├── testng.xml                    # TestNG suite (which tests to run)
└── src/test/java/
    ├── pages/                    # Page Object Model — one class per page
    │   ├── BasePage.java         # Shared wait/click/type helpers
    │   ├── LoginPage.java        # Login screen: locators + actions
    │   └── InventoryPage.java    # Products/cart screen
    └── tests/
        ├── BaseTest.java         # Browser setup/teardown (@Before/@After)
        └── ShopTest.java         # The 4 test cases
```

---

## How to run it 

### 1. Install prerequisites
- **Java JDK 17 or newer** — check: `java -version`
- **Maven** — check: `mvn -version`
- **Google Chrome** installed normally on your laptop

(If you use IntelliJ IDEA, it bundles Maven — you can just open the folder and
click the green run arrow next to a test.)

### 2. Open the project folder in a terminal
```bash
cd selenium-java
```

### 3. Run the tests
```bash
mvn test
```
The first run downloads the dependencies (Selenium, TestNG), then runs all 4
tests. Expected result: `Tests run: 4, Failures: 0`.
`WebDriverManager` downloads the matching chromedriver automatically — no
manual driver setup needed.

### Run from IntelliJ instead
Open the folder → let Maven import → right-click `testng.xml` → **Run**.
Or right-click any single `@Test` method → **Run**.

### Reports
After `mvn test`, TestNG writes a report to:
```
target/surefire-reports/index.html
```
Open it in a browser to show pass/fail results.

---
