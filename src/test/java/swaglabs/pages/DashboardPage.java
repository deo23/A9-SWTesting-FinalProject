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
        return inventoryList.is_displayed();
    }

    public List<WebElement> getProductList() {
        return driver.findElements(By.className("inventory_item"));
    }
}
