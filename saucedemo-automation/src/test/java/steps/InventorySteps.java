package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.InventoryPage;

public class InventorySteps {

    private final InventoryPage page = new InventoryPage();


    @Then("I should be in inventory page")
    public void iShouldBeInInventoryPage() {
        Assert.assertTrue(page.verifyNavigation());
    }
}
