package models;

import java.util.Objects;
/**
 * Represents an item in the SauceDemo Catalog
 * This class is used to retrieve catalog items, compare and verify them with items added to the cart
 *
 * @since 9/9/2025
 */
public class CatalogItem {

    /**
     * The name on the catalog listing. This field is a {@link String}
     */
    private String itemName;

    /**
     * The description of the catalog listing. This field is a {@link String}
     */
    private String itemDesc;

    /**
     * The listing price. This field is a {@link String}
     */
    private String itemPrice;

    /**
     * Constructs a new {@code CatalogItem} object, ideally with information taken directly from the DOM.
     *
     * @param name The name on the catalog listing.
     * @param descKey Key for listing description. The description is stored in the {@link Strings} class and retrieved using the key. This value is saved to the itemDesc property.
     * @param price The listing price
     */
    public CatalogItem(String name, String descKey, String price) {
        this.itemName = name;
        this.itemPrice = price;
        this.itemDesc = Strings.getString(descKey);
    }

    // Getters

    /**
     * @return The catalog listing name as a {@link String}
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @return The catalog listing description as a {@link String}
     */
    public String getItemDesc() {
        return itemDesc;
    }

    /**
     * @return The catalog listing price as a {@link String}
     */
    public String getItemPrice() {
        return itemPrice;
    }

    /**
     * Returns a boolean comparing the current instance of the CatalogItem to a different one.
     *
     * @param item a CatalogItem instance to compare the current one with.
     *
     * @return whether the item is equal to the current instance as a {@link boolean}
     */
    public boolean equals(CatalogItem item) {
        if (this == item) return true; // self
        if (item == null) return false; // null

        return Objects.equals(this.itemName, item.itemName)
                && Objects.equals(this.itemDesc, item.itemDesc)
                && Objects.equals(this.itemPrice, item.itemPrice);
    }

}
