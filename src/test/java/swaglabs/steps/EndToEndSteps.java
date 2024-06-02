package swaglabs.steps;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import swaglabs.pages.CartPage;
import swaglabs.pages.CheckoutCompletePage;
import swaglabs.pages.CheckoutInformationPage;
import swaglabs.pages.CheckoutOverviewPage;
import swaglabs.pages.DashboardPage;
import swaglabs.pages.LoginPage;
import swaglabs.pages.MenuPage;
import swaglabs.pages.ProductDetailPage;
import swaglabs.utils.ChromeDriverSetup;

public class EndToEndSteps {
    private WebDriver driver;
    private DashboardPage dashboardPage;
    private LoginPage loginPage;
    private ProductDetailPage productDetailPage;
    private CartPage cartPage;
    private MenuPage menuPage;
    private CheckoutCompletePage checkoutCompletePage;
    private CheckoutInformationPage checkoutInformationPage;
    private CheckoutOverviewPage checkoutOverviewPage;

    @Given("the application is running and user is login in")
    public void the_application_is_running_and_user_is_login_in() {
        // Assuming ChromeDriverSetup is your custom class for setting up ChromeDriver
        try {
            ChromeDriverSetup.downloadAndExtractChromeDriver();
            driver = ChromeDriverSetup.createWebDriver();
            driver.get("https://www.saucedemo.com/");
            loginPage = new LoginPage(driver);
            loginPage.enterUsername("standard_user");
            loginPage.enterPassword("secret_sauce");
            loginPage.clickLoginButton();
            dashboardPage = new DashboardPage(driver);
            productDetailPage = new ProductDetailPage(driver);
            cartPage = new CartPage(driver);
            menuPage = new MenuPage(driver);
            checkoutCompletePage = new CheckoutCompletePage(driver);
            checkoutInformationPage = new CheckoutInformationPage(driver);
            checkoutOverviewPage = new CheckoutOverviewPage(driver);
            System.out.println("Logged into the dashboard successfully.");
        } catch (Exception e) {
            System.err.println("Error during login: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @When("the user clicks one of the specific product link")
    public void the_user_clicks_one_of_the_specific_product_link() {
        dashboardPage.clickProductById();
    }

    @When("the user adds the product to the cart")
    public void the_user_adds_the_product_to_the_cart() {
        productDetailPage.clickAddToCartButton();
    }

    @When("the user back to dashboard page")
    public void the_user_back_to_dashboard_page() {
        productDetailPage.clickBackToProductsButton();
    }

    @When("the user open the cart page")
    public void the_user_open_the_cart_page() {
        dashboardPage.clickCartButton();
    }

    @When("the user checkout the cart")
    public void the_user_checkout_the_cart() {
        cartPage.clickCheckoutButton();
    }

    @When("the user fill the shipping information")
    public void the_user_fill_the_shipping_information() {
        checkoutInformationPage.fillInformation("Lebron", "James", "40121");
        checkoutInformationPage.continueToOverview();
    }

    @When("the user finish the checkout")
    public void the_user_finish_the_checkout() {
        checkoutOverviewPage.finishCheckout();
    }

    @When("the user back to home page")
    public void the_user_back_to_home_page() {
        checkoutCompletePage.backHome();
    }

    @When("the user click the sidebar menu")
    public void the_user_click_the_sidebar_menu() {
        menuPage.clickHamburger();
        try {
            TimeUnit.SECONDS.sleep(1); // Menunggu selama 1 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("the user logout from the application")
    public void the_user_logout_from_the_application() {
        menuPage.clickLogout();
    }

    @Then("the system logs out the user")
    public void the_system_logs_out_the_user() {
        assert loginPage.isLoginPageDisplayed() : "Login page is not displayed";
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
