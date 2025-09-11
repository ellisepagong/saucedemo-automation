package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class CartPage extends BasePage{

    private final String CART_ADDRESS = "https://www.saucedemo.com/v1/cart.html";

    private final By checkoutButton = By.cssSelector("a.checkout_button");
    private final By errorLabel = By.xpath("//*[@id=\"checkout_info_container\"]/div/form/h3");

    public boolean verifyNavigation() {
        return verifyPage(CART_ADDRESS);
    }

    public void checkout() {
        click(checkoutButton);
    }

    public String getErrorMessage() {
        if(isDisplayed(errorLabel)){
            return getText(errorLabel);
        }
        return "";
    }
}
