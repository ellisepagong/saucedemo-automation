package pages;

import models.CatalogItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage{

    private final String CART_ADDRESS = "https://www.saucedemo.com/cart.html";

    private final By checkoutButton = By.xpath("//*[@id=\"checkout\"]");

    private final By cartItemContainer = By.cssSelector(".cart_item");
    private final By cartItemNameLabel = By.cssSelector(".inventory_item_name");
    private final By cartItemDescLabel = By.cssSelector(".inventory_item_desc");
    private final By cartItemPriceLabel = By.cssSelector(".inventory_item_price");


    public boolean verifyNavigation() {
        return verifyPage(CART_ADDRESS);
    }

    public void checkout() {
        click(checkoutButton);
    }

    public CatalogItem getCartItem(int i) {
        List<WebElement> cartContainers = driver.findElements(cartItemContainer);
        WebElement container = cartContainers.get(i);
        return new CatalogItem(container.findElement(cartItemNameLabel).getText(),
                container.findElement(cartItemDescLabel).getText(),
                container.findElement(cartItemPriceLabel).getText());
    }

    public List<String> getAllCartItemNames() {
        List<String> out = new ArrayList<>();
        List<WebElement> cartContainers = driver.findElements(cartItemContainer);
        for (WebElement container : cartContainers){
            out.add(container.findElement(cartItemNameLabel).getText());
        }
        return out;
    }
}
