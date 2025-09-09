package models;

import java.util.Objects;

public class CatalogItem {

    public CatalogItem(String name, String descKey, String price) {
        this.itemName = name;
        this.itemPrice = price;
        this.itemDesc = Strings.getString(descKey);
    }

    private String itemName;
    private String itemDesc;
    private String itemPrice;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public boolean equals(CatalogItem item) {
        if (this == item) return true; // self
        if (item == null) return false; // null

        return Objects.equals(this.itemName, item.itemName)
                && Objects.equals(this.itemDesc, item.itemDesc)
                && Objects.equals(this.itemPrice, item.itemPrice);
    }

}
