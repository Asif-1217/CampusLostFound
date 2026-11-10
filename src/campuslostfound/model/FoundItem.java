package campuslostfound.model;

import campuslostfound.enums.ItemCategory;
import campuslostfound.enums.ItemStatus;

public class FoundItem extends Item {

    private int finderId;

    public FoundItem(int itemId, String itemName, String description,
                     ItemCategory category, String location, String date,
                     ItemStatus status, int finderId) {

        super(itemId, itemName, description, category,
                location, date, status);

        this.finderId = finderId;
    }

    public int getFinderId() {
        return finderId;
    }

    @Override
    public void displayDetails() {

        System.out.println("Found Item Details");
        System.out.println("Item ID: " + getItemId());
        System.out.println("Item Name: " + getItemName());
        System.out.println("Description: " + getDescription());
        System.out.println("Category: " + getCategory());
        System.out.println("Location: " + getLocation());
        System.out.println("Date: " + getDate());
        System.out.println("Status: " + getStatus());
        System.out.println("Finder ID: " + finderId);
    }
}