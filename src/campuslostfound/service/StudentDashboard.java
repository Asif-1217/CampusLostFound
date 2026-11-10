package campuslostfound.service;

import campuslostfound.model.*;
import campuslostfound.enums.*;

import java.util.Scanner;

public class StudentDashboard {

    private Scanner input;
    private ItemService itemService;
    private ClaimService claimService;

    public StudentDashboard(Scanner input, ItemService itemService,
                            ClaimService claimService) {

        this.input = input;
        this.itemService = itemService;
        this.claimService = claimService;
    }

    public void showDashboard(Student student) {

        while (true) {

            System.out.println("\n===== STUDENT DASHBOARD =====");
            System.out.println("Welcome, " + student.getName());

            System.out.println("1. Report Lost Item");
            System.out.println("2. Report Found Item");
            System.out.println("3. Display All Items");
            System.out.println("4. Search Item");
            System.out.println("5. Submit Claim");
            System.out.println("6. View My Claims");
            System.out.println("7. Logout");

            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(input.nextLine());

            switch (choice) {

                case 1:
                    reportItem(true, student);
                    break;

                case 2:
                    reportItem(false, student);
                    break;

                case 3:
                    itemService.displayAllItems();
                    break;

                case 4:
                    System.out.print("Enter item name: ");
                    itemService.searchItem(input.nextLine());
                    break;

                case 5:
                    submitClaim(student);
                    break;

                case 6:
                    claimService.displayStudentClaims(
                            Integer.parseInt(student.getStudentId())
                    );
                    break;

                case 7:
                    System.out.println("Logout successful!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void reportItem(boolean lost, Student student) {

        System.out.print("Item ID: ");
        int itemId = Integer.parseInt(input.nextLine());

        if (itemService.findItemById(itemId) != null) {
            System.out.println("This Item ID already exists!");
            return;
        }

        System.out.print("Item Name: ");
        String name = input.nextLine();

        System.out.print("Description: ");
        String description = input.nextLine();

        System.out.println("\n===== SELECT CATEGORY =====");
        System.out.println("1. ELECTRONICS");
        System.out.println("2. DOCUMENTS");
        System.out.println("3. ACCESSORIES");
        System.out.println("4. BOOKS");
        System.out.println("5. OTHERS");

        System.out.print("Enter Category Number: ");
        int categoryChoice = Integer.parseInt(input.nextLine());

        ItemCategory category;

        switch (categoryChoice) {
            case 1:
                category = ItemCategory.ELECTRONICS;
                break;

            case 2:
                category = ItemCategory.DOCUMENTS;
                break;

            case 3:
                category = ItemCategory.ACCESSORIES;
                break;

            case 4:
                category = ItemCategory.BOOKS;
                break;

            case 5:
                category = ItemCategory.OTHERS;
                break;

            default:
                System.out.println("Invalid Category!");
                return;
        }

        System.out.print("Location: ");
        String location = input.nextLine();

        System.out.print("Date: ");
        String date = input.nextLine();

        if (lost) {

            LostItem item = new LostItem(
                    itemId, name, description, category,
                    location, date, ItemStatus.REPORTED,
                    Integer.parseInt(student.getStudentId())
            );

            itemService.addItem(item);

        } else {

            FoundItem item = new FoundItem(
                    itemId, name, description, category,
                    location, date, ItemStatus.REPORTED,
                    Integer.parseInt(student.getStudentId())
            );

            itemService.addItem(item);
        }
    }

    private void submitClaim(Student student) {

        System.out.print("Claim ID: ");
        int claimId = Integer.parseInt(input.nextLine());

        System.out.print("Found Item ID: ");
        int itemId = Integer.parseInt(input.nextLine());

        Item item = itemService.findItemById(itemId);

        if (!(item instanceof FoundItem)) {
            System.out.println("Found item not available!");
            return;
        }

        System.out.print("Why is this item yours? ");
        String description = input.nextLine();

        System.out.print("Claim Date: ");
        String date = input.nextLine();

        Claim claim = new Claim(
                claimId,
                itemId,
                Integer.parseInt(student.getStudentId()),
                description,
                date,
                ClaimStatus.PENDING
        );

        claimService.addClaim(claim);
    }
}