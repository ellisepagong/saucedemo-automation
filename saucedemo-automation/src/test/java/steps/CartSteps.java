package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Strings;
import org.junit.Assert;
import pages.CartPage;

public class CartSteps {

    private final CartPage page = new CartPage();

    @Then("I should be in cart page")
    public void iShouldBeInCartPage() {
        Assert.assertTrue(page.verifyNavigation());
    }

    @And("I go to checkout")
    public void iGoToCheckout() {
        page.checkout();
    }

    @Then("I should get the error message {string}")
    public void iShouldGetTheErrorMessageString(String msg) {
        String message = Strings.getString(msg);
        Assert.assertEquals(message, page.getErrorMessage());
    }

}


