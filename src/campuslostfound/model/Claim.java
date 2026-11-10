package campuslostfound.model;

import campuslostfound.enums.ClaimStatus;

public class Claim {

    private int claimId;
    private int itemId;
    private int studentId;
    private String claimDescription;
    private String claimDate;
    private ClaimStatus status;

    public Claim(int claimId, int itemId, int studentId,
                 String claimDescription, String claimDate,
                 ClaimStatus status) {

        this.claimId = claimId;
        this.itemId = itemId;
        this.studentId = studentId;
        this.claimDescription = claimDescription;
        this.claimDate = claimDate;
        this.status = status;
    }

    public int getClaimId() {
        return claimId;
    }

    public int getItemId() {
        return itemId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getClaimDescription() {
        return claimDescription;
    }

    public String getClaimDate() {
        return claimDate;
    }

    public ClaimStatus getStatus() {
        return status;
    }

    public void setStatus(ClaimStatus status) {
        this.status = status;
    }

    public void displayClaim() {

        System.out.println("Claim ID: " + claimId);
        System.out.println("Item ID: " + itemId);
        System.out.println("Student ID: " + studentId);
        System.out.println("Description: " + claimDescription);
        System.out.println("Claim Date: " + claimDate);
        System.out.println("Status: " + status);
    }
}