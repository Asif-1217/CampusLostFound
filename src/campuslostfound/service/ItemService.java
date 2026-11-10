package campuslostfound.service;

import campuslostfound.model.Item;
import campuslostfound.interfaces.Searchable;

import java.util.ArrayList;

public class ItemService implements Searchable {

    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
        System.out.println("Item added successfully!");
    }

    public void displayAllItems() {

        if (items.isEmpty()) {
            System.out.println("No items available.");
            return;
        }

        for (Item item : items) {
            item.displayDetails();
            System.out.println("----------------------");
        }
    }

    @Override
    public void searchItem(String keyword) {

        boolean found = false;

        for (Item item : items) {

            if (item.getItemName().toLowerCase()
                    .contains(keyword.toLowerCase())) {

                item.displayDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching item found.");
        }
    }

    public Item findItemById(int itemId) {

        for (Item item : items) {

            if (item.getItemId() == itemId) {
                return item;
            }
        }

        return null;
    }
}