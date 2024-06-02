package swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailPage {
    private WebDriver driver;

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCorrectProductPageLoaded(String expectedUrl) {
        return driver.getCurrentUrl().equalsIgnoreCase(expectedUrl);
    }

    public void clickAddToCartButton() {
        WebElement addToCartButton = driver.findElement(By.className("btn_inventory"));
        addToCartButton.click();
    }

    public void clickBackToProductsButton() {
        WebElement backButton = driver.findElement(By.className("inventory_details_back_button"));
        backButton.click();
    }

    // Check if the product is added to the cart
    public boolean isProductAddedToCart() {
        WebElement cartItem = driver.findElement(By.className("shopping_cart_badge"));
        return cartItem.isDisplayed();
    }
}
