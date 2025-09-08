package pages;

public class InventoryPage extends BasePage{

    private final String INVENTORY_ADDRESS = "https://www.saucedemo.com/v1/inventory.html";

    public boolean verifyNavigation() {
       return verifyPage(INVENTORY_ADDRESS);
    }
}
