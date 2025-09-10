package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CheckoutPage;

public class CheckoutSteps {

    private final CheckoutPage page = new CheckoutPage();

    @Then("I should be in checkout Page")
    public void iShouldBeInCheckoutPage() {
        Assert.assertTrue(page.verifyNavigation());
    }

    @When("I enter {string}, {string} and {string} in your information")
    public void iEnterCheckoutInformation(String fName, String lName, String zipcode) {
        page.enterInformation(fName, lName, zipcode);
        page.submit();
    }

}

