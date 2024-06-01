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

public class DashboardSteps {
    private WebDriver driver;
    private DashboardPage dashboardPage;
    private LoginPage loginPage;
    private ProductDetailPage productDetailPage;
    private CartPage cartPage;

    @Given("the application is running and successfully logged in")
    public void the_application_is_running_and_successfully_logged_in() {
        try {
            // Assuming ChromeDriverSetup is your custom class for setting up ChromeDriver
            ChromeDriverSetup.downloadAndExtractChromeDriver();
            driver = ChromeDriverSetup.createWebDriver();
            driver.get("https://www.saucedemo.com/");
            loginPage = new LoginPage(driver);
            loginPage.enterUsername("standard_user");
            loginPage.enterPassword("secret_sauce");
            loginPage.clickLoginButton();
            dashboardPage = new DashboardPage(driver);
            System.out.println("Logged into the dashboard successfully.");
        } catch (Exception e) {
            System.err.println("Error during login: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Then("the system displays the dashboard page and shows the list of available products")
    public void the_system_displays_the_dashboard_page_and_shows_the_list_of_available_products() {
        assert dashboardPage.isInventoryListDisplayed() : "Inventory list is not displayed";
        assert dashboardPage.getProductList().size() > 0 : "No products displayed";
    }

    @When("the user clicks on the specific product link")
    public void the_user_clicks_on_the_specific_product_link() {
        dashboardPage.clickProductById();
        productDetailPage = new ProductDetailPage(driver);
    }

    @Then("the system navigates to the product detail page")
    public void the_system_navigates_to_the_product_detail_page() {
        assert productDetailPage.isCorrectProductPageLoaded("https://www.saucedemo.com/inventory-item.html?id=4")
                : "Navigated to incorrect product detail page";
    }

    @When("logged in successfully and click the Cart button")
    public void logged_in_successfully_and_click_the_Cart_button() {
        dashboardPage.clickCartButton();
        cartPage = new CartPage(driver);
    }

    @Then("the system navigates to the cart page")
    public void the_system_navigates_to_the_cart_page() {
        assert cartPage.isCartPageLoaded() : "Cart page is not loaded";
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
