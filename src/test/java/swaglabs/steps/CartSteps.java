package swaglabs.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import swaglabs.pages.DashboardPage;
import swaglabs.pages.CartPage;
import swaglabs.pages.LoginPage;
import swaglabs.utils.ChromeDriverSetup;
import java.io.IOException;

public class CartSteps {
    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CartPage cartPage;

    public CartSteps() {
        try {
            ChromeDriverSetup.downloadAndExtractChromeDriver(); // Download and extract ChromeDriver if not already done
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.driver = ChromeDriverSetup.createWebDriver(); // Initialize WebDriver
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        cartPage = PageFactory.initElements(driver, CartPage.class);
    }

    @Given("the user has successfully logged into the application")
    public void the_user_has_successfully_logged_into_the_application() {
        driver.get("https://www.saucedemo.com/");
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @Given("the user is on the dashboard page")
    public void the_user_is_on_the_dashboard_page() {
        dashboardPage.verifyOnDashboard();
    }

    @Given("at least 1 product is added to the cart")
    public void at_least_1_product_is_added_to_the_cart() {
        dashboardPage.addProductToCart();
    }

    @When("the user clicks the cart button on the dashboard page")
    public void the_user_clicks_the_cart_button_on_the_dashboard_page() {
        dashboardPage.clickCartButton();
    }

    @Then("the system displays the cart page with a list of products added to the cart")
    public void the_system_displays_the_cart_page_with_a_list_of_products_added_to_the_cart() {
        cartPage.verifyProductsInCart();
    }

    @When("the user clicks the checkout button")
    public void the_user_clicks_the_checkout_button() {
        cartPage.clickCheckoutButton();
    }

    @Then("the system displays the checkout page with a checkout information form")
    public void the_system_displays_the_checkout_page_with_a_checkout_information_form() {
        cartPage.verifyCheckoutPage();
    }

    @When("the user clicks the continue shopping button")
    public void the_user_clicks_the_continue_shopping_button() {
        cartPage.clickContinueShoppingButton();
    }

    @Then("the system displays the dashboard page and the previously added products are still in the cart")
    public void the_system_displays_the_dashboard_page_and_the_previously_added_products_are_still_in_the_cart() {
        dashboardPage.verifyOnDashboard();
        dashboardPage.verifyProductsInCart();
    }

     @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
