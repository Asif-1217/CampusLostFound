package campuslostfound.service;

import campuslostfound.model.LostItem;
import campuslostfound.model.FoundItem;
import java.util.ArrayList;

public class MatchingService {

    public void findMatches(LostItem lostItem,
                            ArrayList<FoundItem> foundItems) {

        boolean matched = false;

        for (FoundItem foundItem : foundItems) {

            if (lostItem.getCategory() == foundItem.getCategory()) {

                System.out.println("Possible Match Found!");
                foundItem.displayDetails();

                matched = true;
            }
        }

        if (!matched) {
            System.out.println("No possible match found.");
        }
    }
}