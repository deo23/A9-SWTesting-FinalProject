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

    public void clickProductById() {
        WebElement productLink = driver.findElement(By.id("item_4_title_link"));
        productLink.click();
    }

    public void clickCartButton() {
        WebElement cartButton = driver.findElement(By.className("shopping_cart_link"));
        cartButton.click();
    }

    public void addProductToCart() {
        WebElement firstProductAddButton = driver.findElement(By.xpath("//button[text()='Add to cart']"));
        firstProductAddButton.click();
    }

    public void verifyOnDashboard() {
        if (!isInventoryListDisplayed()) {
            throw new IllegalStateException("Not on the dashboard page");
        }
    }

    public void verifyProductsInCart() {
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        if (cartBadge == null || Integer.parseInt(cartBadge.getText()) == 0) {
            throw new IllegalStateException("Cart is empty");
        }
    }
}
