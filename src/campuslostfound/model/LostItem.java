package campuslostfound.model;

import campuslostfound.enums.ItemCategory;
import campuslostfound.enums.ItemStatus;

public class LostItem extends Item {

    private int studentId;

    public LostItem(int itemId, String itemName, String description,
                    ItemCategory category, String location, String date,
                    ItemStatus status, int studentId) {

        super(itemId, itemName, description, category,
                location, date, status);

        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    @Override
    public void displayDetails() {

        System.out.println("Lost Item Details");
        System.out.println("Item ID: " + getItemId());
        System.out.println("Item Name: " + getItemName());
        System.out.println("Description: " + getDescription());
        System.out.println("Category: " + getCategory());
        System.out.println("Location: " + getLocation());
        System.out.println("Date: " + getDate());
        System.out.println("Status: " + getStatus());
        System.out.println("Student ID: " + studentId);
    }
}