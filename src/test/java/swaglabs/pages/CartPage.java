package swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCartPageLoaded() {
        return driver.getCurrentUrl().equalsIgnoreCase("https://www.saucedemo.com/cart.html");
    }
}
