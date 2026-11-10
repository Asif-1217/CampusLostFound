package campuslostfound.model;

public class Admin extends User {

    private String adminId;

    public Admin(int userId, String name, String email,
                 String password, String adminId) {

        super(userId, name, email, password);

        this.adminId = adminId;
    }

    public String getAdminId() {
        return adminId;
    }

    @Override
    public void displayDashboard() {
        System.out.println("Welcome Admin!");
        System.out.println("Name: " + getName());
        System.out.println("Admin ID: " + adminId);
    }
}