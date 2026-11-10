package campuslostfound.service;

import campuslostfound.model.Claim;
import campuslostfound.enums.ClaimStatus;

import java.util.ArrayList;

public class ClaimService {

    private ArrayList<Claim> claims = new ArrayList<>();

    public void addClaim(Claim claim) {
        claims.add(claim);
        System.out.println("Claim submitted successfully!");
    }

    public void displayAllClaims() {

        if (claims.isEmpty()) {
            System.out.println("No claims available.");
            return;
        }

        for (Claim claim : claims) {
            claim.displayClaim();
            System.out.println("----------------------");
        }
    }

    public void updateClaimStatus(int claimId, ClaimStatus status) {

        for (Claim claim : claims) {

            if (claim.getClaimId() == claimId) {
                claim.setStatus(status);
                System.out.println("Claim status updated!");
                return;
            }
        }

        System.out.println("Claim not found.");
    }

    public void displayStudentClaims(int studentId) {

        boolean found = false;

        for (Claim claim : claims) {

            if (claim.getStudentId() == studentId) {
                claim.displayClaim();
                System.out.println("----------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No claims found for this student.");
        }
    }
}