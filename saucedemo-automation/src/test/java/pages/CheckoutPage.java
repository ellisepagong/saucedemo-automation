package pages;

import models.CatalogItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutPage extends BasePage{


    private final String CHECKOUT_ADDRESS = "https://www.saucedemo.com/checkout-step-one.html";
    private final String OVERVIEW_ADDRESS = "https://www.saucedemo.com/checkout-step-two.html";
    private final String CHECKOUT_COMPLETE_ADDRESS = "https://www.saucedemo.com/checkout-complete.html";


    // Step 1
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");
    private final By errorLabel = By.cssSelector(".error-message-container");
    private final By continueButton = By.cssSelector("input.cart_button");

    // Step 2
    private final By cartItemContainers = By.cssSelector(".cart_item");
    private final By itemNameLabel = By.cssSelector(".inventory_item_name");
    private final By itemDescLabel = By.cssSelector(".inventory_item_desc");
    private final By itemPriceLabel = By.cssSelector(".inventory_item_price");
    private final By totalPriceLabel = By.cssSelector(".summary_total_label");
    private final By finishButton = By.xpath("//*[@id=\"finish\"]");

    // Step 3


    // Step 1 Checkout

    public boolean verifyCheckoutPage() {
        return verifyPage(CHECKOUT_ADDRESS);
    }

    public void enterInformation(String fName, String lName, String zipcode) {
        type(firstNameField, fName);
        type(lastNameField, lName);
        type(postalCodeField, zipcode);
    }

    public String getErrorMessage() {
        if(isDisplayed(errorLabel)){
            return getText(errorLabel);
        }
        return "";
    }

    public void submit() {
        click(continueButton);
    }

    // Step 2 Checkout

    public boolean verifyOverviewPage() {
        return verifyPage(OVERVIEW_ADDRESS);
    }

    public CatalogItem getOverviewItem(int i) {
        List<WebElement> containers = driver.findElements(cartItemContainers);
        WebElement container = containers.get(i);
        return new CatalogItem(container.findElement(itemNameLabel).getText(),
                container.findElement(itemDescLabel).getText(),
                container.findElement(itemPriceLabel).getText());
    }

    public String getTotalPrice() {
        return getText(totalPriceLabel);
    }

    public void clickFinish() {
        click(finishButton);
    }

    // Step 3 Checkout
    public boolean verifyCheckoutCompletePage() {
        return verifyPage(CHECKOUT_COMPLETE_ADDRESS);
    }



}
