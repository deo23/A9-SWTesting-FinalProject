package swaglabs.steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import swaglabs.pages.DashboardPage;
import swaglabs.pages.LoginPage;
import swaglabs.pages.MenuPage;
import swaglabs.utils.ChromeDriverSetup;

public class MenuSteps {
    private MenuPage menuPage;
    private LoginPage loginPage;
    private WebDriver driver;
    private DashboardPage dashboardPage;
    
    @Given("application is running and successfully logged in")
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
            menuPage = new MenuPage(driver);
            System.out.println("Logged into the dashboard successfully.");
        } catch (Exception e) {
            System.err.println("Error during login: " + e.getMessage());
            e.printStackTrace();
        }
    }
    @When("the user clicks on the humburger button")
    public void the_user_clicks_on_the_hamburger_menu() {
        menuPage.clickHamburger();
    }

    @When("the user clicks on the All Items menu")
    public void the_user_clicks_on_the_All_items_menu() {
        menuPage.clickAllitems();
    }

    @Then("the system displays All Items on the menu page")
    public void the_system_displays_the_list_of_available_products() {
        assert dashboardPage.isInventoryListDisplayed() : "Inventory list is not displayed";
        assert dashboardPage.getProductList().size() > 0 : "No products displayed";
    }
}