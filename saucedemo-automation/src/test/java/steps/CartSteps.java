package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import models.CatalogItem;
import models.Strings;
import org.junit.Assert;
import pages.CartPage;
import pages.SidePanel;

import java.util.ArrayList;
import java.util.List;

public class CartSteps {

    private final CartPage page = new CartPage();
    private final SidePanel panel = new SidePanel();

    @Then("I should be in cart page")
    public void iShouldBeInCartPage() {
        Assert.assertTrue(page.verifyNavigation());
    }

    @And("I go to checkout")
    public void iGoToCheckout() {
        page.checkout();
    }

    @Then("I verify cart contents")
    public void iVerifyCartContents(List<String> cartItems) {
        for (int i = 0; i < cartItems.size(); i++){
            CatalogItem item = page.getCartItem(i);
            Assert.assertEquals(cartItems.get(i), item.getItemName());
        }

    }

    @And("I log out")
    public void iLogOut() {
        panel.logout();
    }

    @Then("I verify if there are missing cart items")
    public void iVerifyIfThereAreMissingCartItems(List<String> cartItems) {
        List<String> missingItems = new ArrayList<>();
        List<String> cartActualItems = page.getAllCartItemNames();
        for (String cartItem : cartItems) {
            if (!cartActualItems.contains(cartItem)) {
                missingItems.add(cartItem);
            }
        }
        Assert.assertFalse(missingItems.isEmpty());
    }
}


