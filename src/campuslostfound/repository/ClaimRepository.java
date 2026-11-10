package campuslostfound.repository;

import campuslostfound.model.Claim;
import java.util.ArrayList;

public class ClaimRepository {

    private ArrayList<Claim> claims = new ArrayList<>();

    public void addClaim(Claim claim) {
        claims.add(claim);
        System.out.println("Claim saved successfully!");
    }

    public Claim findClaimById(int claimId) {

        for (Claim claim : claims) {

            if (claim.getClaimId() == claimId) {
                return claim;
            }
        }

        return null;
    }

    public ArrayList<Claim> getAllClaims() {
        return claims;
    }

    public void displayAllClaims() {

        if (claims.isEmpty()) {
            System.out.println("No claims available.");
            return;
        }

        for (Claim claim : claims) {
            claim.displayClaim();
            System.out.println("--------------------");
        }
    }
}