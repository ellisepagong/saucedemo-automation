package models;

import java.util.Objects;

/**
 * Represents an item in the SauceDemo e-commerce catalog.
 *
 * <p>This model class encapsulates the attributes of a product
 * listing in the SauceDemo application. It is primarily used for:
 * <ul>
 *   <li>Retrieving and storing catalog item information from the DOM</li>
 *   <li>Comparing catalog items with items added to the shopping cart</li>
 *   <li>Validating product data consistency across different application pages</li>
 *   <li>Supporting test automation scenarios that involve product verification</li>
 * </ul>
 * </p>
 *
 * <p>The class follows the Value Object pattern where equality is based on
 * the content of the item rather than object identity. Two CatalogItem instances
 * are considered equal if they have the same name, description, and price.</p>
 *
 * <p>Descriptions are retrieved from the {@link Strings} class using a key-based
 * lookup system, which centralizes text management and supports localization.</p>
 *
 * @author Ellise Pag-Ong
 * @version 1.0
 * @since 2025-09-09
 *
 * @see Strings
 */
public class CatalogItem {

    /**
     * The display name of the catalog item as shown on the product listing.
     *
     * <p>This field contains the human-readable name that identifies the product
     * in the catalog, such as "Sauce Labs Backpack" or "Sauce Labs Bike Light".
     * The name is typically extracted directly from the product card element
     * in the DOM and used for identification and comparison purposes.</p>
     *
     * @see #getItemName()
     */
    private String itemName;

    /**
     * The detailed description of the catalog item.
     *
     * <p>This field contains the product description text that provides
     * additional information about the item. The description is retrieved
     * from the {@link Strings} class using a key-based lookup system,
     * which allows for centralized text management and potential localization.</p>
     *
     * @see Strings#getString(String)
     * @see #getItemDesc()
     */
    private String itemDesc;

    /**
     * The monetary price of the catalog item.
     *
     * <p>This field contains the price as a formatted string (e.g., "$29.99").
     * The price is typically extracted from the product card and used for
     * price verification, cart validation, and checkout testing scenarios.
     * Note that this is stored as a String to preserve formatting and avoid
     * floating-point precision issues.</p>
     *
     * @see #getItemPrice()
     */
    private String itemPrice;

    /**
     * Constructs a new CatalogItem with the specified attributes.
     *
     * <p>This constructor is typically used when extracting product information
     * directly from the DOM elements on the catalog page. The description is
     * resolved using the provided key to maintain consistency with the
     * centralized text management system.</p>
     *
     * @param name    the display name of the catalog item, must not be null
     * @param descKey the key used to retrieve the description from the
     *                {@link Strings} class, must correspond to a valid key
     * @param price   the formatted price string of the item, must not be null
     *
     * @throws IllegalArgumentException if name or price is null
     * @throws RuntimeException if descKey does not correspond to a valid
     *         description in the Strings class
     *
     * @see Strings#getString(String)
     */
    public CatalogItem(String name, String descKey, String price) {
        this.itemName = name;
        this.itemPrice = price;
        this.itemDesc = Strings.getString(descKey);
    }

    /**
     * Returns the display name of this catalog item.
     *
     * <p>The item name is the primary identifier for the product and is used
     * in various test scenarios including product selection, cart verification,
     * and order confirmation.</p>
     *
     * @return the product name as a non-null String
     *
     * @see #itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Returns the description of this catalog item.
     *
     * <p>The item description provides detailed information about the product
     * features and characteristics. This text is managed centrally through
     * the {@link Strings} class for consistency across the application.</p>
     *
     * @return the product description as a non-null String
     *
     * @see #itemDesc
     * @see Strings
     */
    public String getItemDesc() {
        return itemDesc;
    }

    /**
     * Returns the price of this catalog item.
     *
     * <p>The item price is returned as a formatted string that includes
     * the currency symbol and decimal formatting (e.g., "$15.99").
     * This preserves the exact formatting as displayed to users and
     * avoids floating-point arithmetic issues.</p>
     *
     * @return the formatted price string as a non-null String
     *
     * @see #itemPrice
     */
    public String getItemPrice() {
        return itemPrice;
    }

    /**
     * Compares this CatalogItem with another object for equality.
     *
     * <p>Two CatalogItem instances are considered equal if they have
     * identical values for all three attributes: name, description, and price.
     * This implements value-based equality rather than reference equality.</p>
     *
     * <p>The comparison uses {@link Objects#equals(Object, Object)} to safely
     * handle null values in any of the attributes.</p>
     *
     * @param item the CatalogItem instance to compare with this CatalogItem, may be null
     *
     * @return true if the objects are equal, false otherwise
     *
     * @see Object#equals(Object)
     * @see Objects#equals(Object, Object)
     */
    public boolean equals(CatalogItem item) {
        if (this == item) return true; // self
        if (item == null) return false; // null

        return Objects.equals(this.itemName, item.itemName)
                && Objects.equals(this.itemDesc, item.itemDesc)
                && Objects.equals(this.itemPrice, item.itemPrice);
    }

}
