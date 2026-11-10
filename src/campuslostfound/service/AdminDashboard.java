package campuslostfound.service;

import campuslostfound.enums.ClaimStatus;
import java.util.Scanner;

public class AdminDashboard {

    private Scanner input;
    private ClaimService claimService;
    private ItemService itemService;

    public AdminDashboard(Scanner input,
                          ClaimService claimService,
                          ItemService itemService) {

        this.input = input;
        this.claimService = claimService;
        this.itemService = itemService;
    }

    public void showDashboard() {

        while (true) {

            System.out.println("\n===== ADMIN DASHBOARD =====");
            System.out.println("1. View All Items");
            System.out.println("2. View All Claims");
            System.out.println("3. Approve Claim");
            System.out.println("4. Reject Claim");
            System.out.println("5. Logout");

            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(input.nextLine());

            switch (choice) {

                case 1:
                    itemService.displayAllItems();
                    break;

                case 2:
                    claimService.displayAllClaims();
                    break;

                case 3:
                    updateClaim(ClaimStatus.APPROVED);
                    break;

                case 4:
                    updateClaim(ClaimStatus.REJECTED);
                    break;

                case 5:
                    System.out.println("Admin Logout Successful!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void updateClaim(ClaimStatus status) {

        System.out.print("Enter Claim ID: ");
        int claimId = Integer.parseInt(input.nextLine());

        claimService.updateClaimStatus(claimId, status);
    }
}