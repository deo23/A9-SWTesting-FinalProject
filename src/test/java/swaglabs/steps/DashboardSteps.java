package swaglabs.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import swaglabs.pages.DashboardPage;
import swaglabs.utils.ChromeDriverSetup;

public class DashboardSteps {
    private WebDriver driver;
    private DashboardPage dashboardPage;

    @Given("the application is running and successfully logged in")
    public void the_application_is_running_and_successfully_logged_in() {
        try {
            // Assuming ChromeDriverSetup is your custom class for setting up ChromeDriver
            ChromeDriverSetup.downloadAndExtractChromeDriver();
            driver = ChromeDriverSetup.createWebDriver();
            driver.get("https://www.saucedemo.com/");
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
}
