package steps;

import io.cucumber.java.DataTableType;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.CatalogItem;
import org.junit.Assert;
import pages.InventoryPage;
import java.util.List;
import java.util.Map;

public class InventorySteps {

    private final InventoryPage page = new InventoryPage();

    @DataTableType
    public CatalogItem catalogItem(Map<String, String> row){
            return new CatalogItem(row.get("Item Name"),
                                    row.get("Item Description"),
                                    row.get("Item Price"));
        }

    @Then("I should be in inventory page")
    public void iShouldBeInInventoryPage() {
        Assert.assertTrue(page.verifyNavigation());
    }

    @Then("I verify the following items in catalog")
    public void iVerifyTheFollowingItemsInCatalog(List<CatalogItem> catalog) {
        for(int i=0; i< catalog.size(); i++){
            CatalogItem item = catalog.get(i);
            Assert.assertTrue(item.equals(page.getCatalogItem(i)));
        }
    }

    /**
     * Sorts catalog in various orders
     *
     * @param option the value of select option:
     *
     *      az - Alphabetical
     *      za - reverse alphabetical
     *      lohi - price low to high
     *      hilo - price high to low
     */

    @When("I sort catalog by {string}")
    public void iSortCatalogByString(String option) {
        page.sortBy(option);
    }

    @When("I add the following items to cart")
    public void iAddTheFollowingItemsToCart(List<String> items) {
        for (String item: items){
            page.addToCart(item);
        }
    }

    @And("I go to cart")
    public void iGoToCart() {
        page.clickCart();
    }

    @When("I go to inventory page")
    public void iGoToInventoryPage() {
        page.goToInventory();
    }

    @Then("I verify images not displaying")
    public void iVerifyImagesNotDisplaying() {
        Assert.assertTrue(page.imagesBroken());
    }

    @Then("I verify images are incorrect")
    public void iVerifyImagesAreIncorrect() {
        Assert.assertFalse(page.verifyImages());
    }
}
