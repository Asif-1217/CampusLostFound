package campuslostfound.repository;

import campuslostfound.model.Item;
import java.util.ArrayList;

public class ItemRepository {

    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
        System.out.println("Item saved successfully!");
    }

    public Item findItemById(int itemId) {

        for (Item item : items) {

            if (item.getItemId() == itemId) {
                return item;
            }
        }

        return null;
    }

    public ArrayList<Item> getAllItems() {
        return items;
    }

    public void displayAllItems() {

        if (items.isEmpty()) {
            System.out.println("No items available.");
            return;
        }

        for (Item item : items) {
            item.displayDetails();
            System.out.println("--------------------");
        }
    }
}