package pages;

import models.CatalogItem;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class InventoryPage extends BasePage{

    private final String INVENTORY_ADDRESS = "https://www.saucedemo.com/v1/inventory.html";

    private final By inventoryItems = By.cssSelector(".inventory_item");

    private final By itemLabel = By.cssSelector(".inventory_item_name");
    private final By itemDesc = By.cssSelector(".inventory_item_desc");
    private final By itemPrice = By.cssSelector(".inventory_item_price");

    private final By sortSelect = By.cssSelector(".product_sort_container");

    private final By addToCartButton = By.cssSelector("button.btn_inventory");
    private final By cartButton = By.cssSelector(".shopping_cart_link");

    public boolean verifyNavigation() {
       return verifyPage(INVENTORY_ADDRESS);
    }

    public CatalogItem getCatalogItem(int x) {
        List<WebElement> containers = driver.findElements(inventoryItems);
        WebElement container = containers.get(x);
        return new CatalogItem(container.findElement(itemLabel).getText(),
                container.findElement(itemDesc).getText(),
                container.findElement(itemPrice).getText());
    }

    public void sortBy(String value) {
        Select select = new Select(driver.findElement(sortSelect));
        select.selectByValue(value);
    }

    public void addToCart(String itemName) {
        List<WebElement> containers = driver.findElements(inventoryItems);
        boolean found = false;
        for (WebElement container : containers){
            if(container.findElement(itemLabel).getText().equals(itemName)){
                WebElement button = container.findElement(addToCartButton);
                button.click();
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IllegalArgumentException("Item with name '" + itemName + "' not found in inventory.");
        }
    }

    public void clickCart() {
        click(cartButton);
    }
}
