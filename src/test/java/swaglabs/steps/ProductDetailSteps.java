package swaglabs.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

import swaglabs.pages.CartPage;
import swaglabs.pages.DashboardPage;
import swaglabs.pages.LoginPage;
import swaglabs.pages.ProductDetailPage;
import swaglabs.utils.ChromeDriverSetup;
import swaglabs.steps.DashboardSteps;

public class ProductDetailSteps {
    private WebDriver driver;
    private DashboardPage dashboardPage;
    private LoginPage loginPage;
    private ProductDetailPage productDetailPage;
    private CartPage cartPage;

    @Given("the user is on the product detail page")
    public void the_user_is_on_the_product_detail_page() {
        try {
            ChromeDriverSetup.downloadAndExtractChromeDriver();
            driver = ChromeDriverSetup.createWebDriver();
            driver.get("https://www.saucedemo.com/");
            loginPage = new LoginPage(driver);
            loginPage.enterUsername("standard_user");
            loginPage.enterPassword("secret_sauce");
            loginPage.clickLoginButton();
            dashboardPage = new DashboardPage(driver);
            dashboardPage.clickProductById();
            productDetailPage = new ProductDetailPage(driver);
            System.out.println("Navigated to the product detail page successfully.");
        } catch (Exception e) {
            System.err.println("Error during navigation to product detail page: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @When("the user clicks the Add to Cart button")
    public void the_user_clicks_the_Add_to_Cart_button() {
        productDetailPage.clickAddToCartButton();
    }

    @Then("the system adds the product to the cart")
    public void the_system_adds_the_product_to_the_cart() {
        assert productDetailPage.isProductAddedToCart() : "Product is not added to the cart";
    }

    @When("the user clicks the back button")
    public void the_user_clicks_the_Back_to_Products_button() {
        productDetailPage.clickBackToProductsButton();
    }

    @Then("the system navigates to the dashboard page")
    public void the_system_navigates_back_to_the_dashboard_page() {
        assert dashboardPage.isInventoryListDisplayed() : "Inventory list is not displayed";
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
