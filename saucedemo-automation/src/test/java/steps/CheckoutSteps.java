package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.CatalogItem;
import org.junit.Assert;
import pages.CheckoutPage;

import java.util.List;

public class CheckoutSteps {

    private final CheckoutPage page = new CheckoutPage();


    // Step 1 Checkout
    @Then("I should be in checkout Page")
    public void iShouldBeInCheckoutPage() {
        Assert.assertTrue(page.verifyCheckoutPage());
    }

    @When("I enter {string}, {string} and {string} in your information")
    public void iEnterCheckoutInformation(String fName, String lName, String zipcode) {
        page.enterInformation(fName, lName, zipcode);
        page.submit();
    }

    // Step 2 Checkout

    @Then("I should be in overview page")
    public void iShouldBeInOverviewPage() {
        Assert.assertTrue(page.verifyOverviewPage());
    }

    @Then("I verify cart contents and price")
    public void iVerifyCartContentsAndPrice(List<String> itemNames) {
        double itemTotal = 0;
        for (int i = 0; i < itemNames.size(); i++){
            CatalogItem item = page.getOverviewItem(i);
            Assert.assertEquals(itemNames.get(i), item.getItemName());
            String price = item.getItemPrice();
            itemTotal += Double.parseDouble(price.substring(1));
        }
        itemTotal = (double) Math.round((itemTotal*1.08) * 100) / 100;
        String totalPrice = page.getTotalPrice();
        Assert.assertTrue(itemTotal == Double.parseDouble(totalPrice.substring(8)));
    }

    @And("I finish checkout")
    public void iFinishCheckout() {
        page.clickFinish();
    }

    // Checkout Complete

    @Then("transaction should be successful")
    public void transactionShouldBeSuccessful() {
        Assert.assertTrue(page.verifyCheckoutCompletePage());
    }
}

