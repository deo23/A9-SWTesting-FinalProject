package swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DashboardPage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isInventoryListDisplayed() {
        WebElement inventoryList = driver.findElement(By.className("inventory_list"));
        return inventoryList.isDisplayed();
    }

    public List<WebElement> getProductList() {
        return driver.findElements(By.className("inventory_item"));
    }

    // Click the specific product link by ID
    public void clickProductById() {
        WebElement productLink = driver.findElement(By.id("item_4_title_link"));
        productLink.click();
    }

    // Click the cart button
    public void clickCartButton() {
        WebElement cartButton = driver.findElement(By.className("shopping_cart_link"));
        cartButton.click();
    }
}
