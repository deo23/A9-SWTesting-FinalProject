package swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuPage {
    private WebDriver driver;
    
    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickHamburger() {
        WebElement hamburgerButton = driver.findElement(By.id("react-burger-menu-btn"));
        hamburgerButton.click();
    }

    public void clickAllitems() {
        WebElement allItemsButton = driver.findElement(By.id("inventory_sidebar_link"));
        allItemsButton.click();
    }

    public void clickLogout() {
        WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
        logoutButton.click();
    }
    
    public void clickAbout() {
        WebElement aboutButton = driver.findElement(By.id("about_sidebar_link"));
        aboutButton.click();
    }

}
