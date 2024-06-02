package swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    private WebDriver driver;

    @FindBy(className = "title")
    private WebElement productTitle;

    @FindBy(className = "btn_inventory")
    private WebElement addToCartButton;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartLink;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public void goToCart() {
        cartLink.click();
    }

    public boolean isAtProductsPage() {
        return productTitle.isDisplayed();
    }
}