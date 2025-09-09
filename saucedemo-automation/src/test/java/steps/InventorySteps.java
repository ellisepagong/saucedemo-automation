package steps;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
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

    @And("I verify the following items in catalog")
    public void iVerifyTheFollowingItemsInCatalog(List<CatalogItem> catalog) {
        for(int i=0; i< catalog.size(); i++){
            CatalogItem item = catalog.get(i);
            Assert.assertTrue(item.equals(page.getCatalogItem(i)));
        }
    }
}
