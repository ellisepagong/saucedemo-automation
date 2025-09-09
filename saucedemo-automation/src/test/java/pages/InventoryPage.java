package pages;

import models.CatalogItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;


public class InventoryPage extends BasePage{

    private final String INVENTORY_ADDRESS = "https://www.saucedemo.com/v1/inventory.html";

    private final By inventoryItems = By.cssSelector(".inventory_item");

    private final By itemLabel = By.cssSelector(".inventory_item_name");
    private final By itemDesc = By.cssSelector(".inventory_item_desc");
    private final By itemPrice = By.cssSelector(".inventory_item_price");


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
}
