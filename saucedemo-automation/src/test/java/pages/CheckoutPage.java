package pages;

import org.openqa.selenium.By;

public class CheckoutPage extends BasePage{


    private final String CHECKOUT_ADDRESS = "https://www.saucedemo.com/v1/checkout-step-one.html";

    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");

    private final By continueButton = By.cssSelector("input.cart_button");

    public boolean verifyNavigation() {
        return verifyPage(CHECKOUT_ADDRESS);
    }

    public void enterInformation(String fName, String lName, String zipcode) {
        type(firstNameField, fName);
        type(lastNameField, lName);
        type(postalCodeField, zipcode);
    }

    public void submit() {
        click(continueButton);
    }
}
