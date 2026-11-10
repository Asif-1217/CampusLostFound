package campuslostfound.model;

import campuslostfound.enums.ItemCategory;
import campuslostfound.enums.ItemStatus;

public abstract class Item {

    private int itemId;
    private String itemName;
    private String description;
    private ItemCategory category;
    private String location;
    private String date;
    private ItemStatus status;

    public Item(int itemId, String itemName, String description,
                ItemCategory category, String location, String date,
                ItemStatus status) {

        this.itemId = itemId;
        this.itemName = itemName;
        this.description = description;
        this.category = category;
        this.location = location;
        this.date = date;
        this.status = status;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public ItemStatus getStatus() {
        return status;
    }

    public abstract void displayDetails();
}