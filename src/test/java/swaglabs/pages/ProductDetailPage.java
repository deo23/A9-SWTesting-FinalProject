package swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class ProductDetailPage {
    private WebDriver driver;

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCorrectProductPageLoaded(String expectedUrl) {
        return driver.getCurrentUrl().equalsIgnoreCase(expectedUrl);
    }
}
