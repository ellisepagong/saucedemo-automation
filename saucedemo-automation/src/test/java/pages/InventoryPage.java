package pages;

import models.CatalogItem;
import models.Strings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Objects;


public class InventoryPage extends BasePage{

    private final String INVENTORY_ADDRESS = "https://www.saucedemo.com/inventory.html";

    private final By inventoryItems = By.cssSelector(".inventory_item");

    private final By itemLabel = By.cssSelector(".inventory_item_name");
    private final By itemDesc = By.cssSelector(".inventory_item_desc");
    private final By itemPrice = By.cssSelector(".inventory_item_price");
    private final By itemImage = By.cssSelector("img.inventory_item_img");

    private final By sortSelect = By.cssSelector(".product_sort_container");

    private final By addToCartButton = By.cssSelector("button.btn_inventory");
    private final By cartButton = By.id("shopping_cart_container");

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

    public void goToInventory() {
        navigate(INVENTORY_ADDRESS);
    }

    public boolean imagesBroken() {
        List<WebElement> containers = driver.findElements(inventoryItems);
        for (WebElement container : containers){
            WebElement image = container.findElement(itemImage);
            if(Objects.equals(image.getAttribute("naturalWidth"), "0")){
                return true;
            }
        }
        return false;
    }

    public boolean verifyImages() {
        List<WebElement> containers = driver.findElements(inventoryItems);
        String[] URLS = Strings.CATALOG_IMAGES;
        for (int i = 0; i<containers.size(); i++){
            WebElement container = containers.get(i);
            String imageURL = container.findElement(itemImage).getAttribute("src");
            assert imageURL != null;
            if (!imageURL.equals(URLS[i])){
                return false;
            }
        }
        return true;
    }

    public boolean sortErrorExists() {
        if (Objects.equals(driver.switchTo().alert().getText(), "Sorting is broken! This error has been reported to Backtrace.")){
            driver.switchTo().alert().accept();
            return true;
        }else{return false;}
    }

    public boolean waitForLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        long startTime = new Date().getTime();
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        long endTime = new Date().getTime();
        long duration = endTime-startTime;
        System.out.println("  Total time elapsed while waiting: " + duration + " milliseconds");
        return driver.findElement(cartButton).isDisplayed();
    }
}
