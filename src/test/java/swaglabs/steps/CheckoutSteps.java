package swaglabs.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import swaglabs.pages.*;
import swaglabs.utils.ChromeDriverSetup;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class CheckoutSteps {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutInformationPage checkoutInformationPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutCompletePage checkoutCompletePage;

    @Given("already accessed the checkout complete page")
    public void already_accessed_the_checkout_complete_page() throws IOException {
        driver = ChromeDriverSetup.createWebDriver(); // Membuat instance WebDriver untuk Chrome
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage = new ProductsPage(driver);
        productsPage.addToCart();
        productsPage.goToCart();
        cartPage = new CartPage(driver);
        cartPage.clickCheckoutButton();
        checkoutInformationPage = new CheckoutInformationPage(driver);
        checkoutInformationPage.fillInformation("Lebron", "James", "40121");
        checkoutInformationPage.continueToOverview();
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.finishCheckout();
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    @When("clicking the Back Home button")
    public void clicking_the_back_home_button() {
        checkoutCompletePage.backHome();
    }

    @Then("the system displays the dashboard page")
    public void the_system_displays_the_dashboard_page() {
        productsPage = new ProductsPage(driver);
        assertTrue(productsPage.isAtProductsPage());
        driver.quit();
    }

    @Given("already on the checkout overview page and clicked continue")
    public void already_on_the_checkout_overview_page_and_clicked_continue() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage = new ProductsPage(driver);
        productsPage.addToCart();
        productsPage.goToCart();
        cartPage = new CartPage(driver);
        cartPage.clickCheckoutButton();
        checkoutInformationPage = new CheckoutInformationPage(driver);
        checkoutInformationPage.fillInformation("Lebron", "James", "40121");
        checkoutInformationPage.continueToOverview();
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
    }

    @When("clicking the Finish button")
    public void clicking_the_finish_button() {
        checkoutOverviewPage.finishCheckout();
    }

    @Then("the system displays the checkout complete page")
    public void the_system_displays_the_checkout_complete_page() {
        checkoutCompletePage = new CheckoutCompletePage(driver);
        assertTrue(checkoutCompletePage.isAtCheckoutCompletePage());
        driver.quit();
    }

    @Given("already added products to the cart and clicked checkout")
    public void already_added_products_to_the_cart_and_clicked_checkout() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage = new ProductsPage(driver);
        productsPage.addToCart();
        productsPage.goToCart();
        cartPage = new CartPage(driver);
        cartPage.clickCheckoutButton();
        checkoutInformationPage = new CheckoutInformationPage(driver);
    }

    @When("clicking the Cancel button")
    public void clicking_the_cancel_button() {
        checkoutInformationPage.cancel();
    }

    @Then("the system displays the cart page")
    public void the_system_displays_the_cart_page() {
        assertTrue(cartPage.isCartPageLoaded());
        driver.quit();
    }
}
