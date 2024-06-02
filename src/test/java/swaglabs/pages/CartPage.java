package swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCartPageLoaded() {
        return driver.getCurrentUrl().equalsIgnoreCase("https://www.saucedemo.com/cart.html");
    }

    public boolean isCorrectProductPageLoaded(String expectedUrl) {
        return driver.getCurrentUrl().equalsIgnoreCase(expectedUrl);
    }

    public void clickCheckoutButton() {
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
    }

    public void clickContinueShoppingButton() {
        WebElement continueShoppingButton = driver.findElement(By.id("continue-shopping"));
        continueShoppingButton.click();
    }

    public void verifyProductsInCart() {
        WebElement cartItems = driver.findElement(By.className("cart_item"));
        if (cartItems == null) {
            throw new IllegalStateException("No products in the cart");
        }
    }

    public void verifyCheckoutPage() {
        WebElement checkoutInformation = driver.findElement(By.id("checkout_info_container"));
        if (checkoutInformation == null) {
            throw new IllegalStateException("Not on the checkout page");
        }
    }
}
