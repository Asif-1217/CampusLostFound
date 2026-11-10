package campuslostfound.main;

import campuslostfound.model.*;
import campuslostfound.service.*;
import campuslostfound.repository.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ItemService itemService = new ItemService();
        ClaimService claimService = new ClaimService();

        UserRepository userRepository = new UserRepository();

        Admin defaultAdmin = new Admin(
                0,
                "System Admin",
                "admin@campus.com",
                "admin123",
                "ADMIN-001"
        );

        userRepository.addUser(defaultAdmin);

        AuthService authService = new AuthService(userRepository);

        StudentDashboard studentDashboard =
                new StudentDashboard(input, itemService, claimService);

        AdminDashboard adminDashboard =
                new AdminDashboard(input, claimService, itemService);

        int nextUserId = 1;

        while (true) {

            System.out.println("\n===== CAMPUS LOST & FOUND SYSTEM =====");
            System.out.println("1. Student Registration");
            System.out.println("2. Student Login");
            System.out.println("3. Admin Login");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(input.nextLine());

            switch (choice) {

                case 1:

                    System.out.println("\n===== STUDENT REGISTRATION =====");

                    System.out.print("Name: ");
                    String name = input.nextLine();

                    System.out.print("Email: ");
                    String email = input.nextLine();

                    System.out.print("Password: ");
                    String password = input.nextLine();

                    System.out.print("Student ID (numbers only): ");
                    String studentId = input.nextLine();

                    System.out.print("Department: ");
                    String department = input.nextLine();

                    authService.registerStudent(
                            nextUserId,
                            name,
                            email,
                            password,
                            studentId,
                            department
                    );

                    if (userRepository.findUserByEmail(email) != null) {
                        nextUserId++;
                    }

                    break;

                case 2:

                    System.out.println("\n===== STUDENT LOGIN =====");

                    System.out.print("Email: ");
                    String loginEmail = input.nextLine();

                    System.out.print("Password: ");
                    String loginPassword = input.nextLine();

                    User user = authService.login(
                            loginEmail, loginPassword
                    );

                    if (user instanceof Student) {

                        studentDashboard.showDashboard((Student) user);

                    } else if (user instanceof Admin) {

                        System.out.println("Admin account detected.");

                    }

                    break;

                case 3:

                    System.out.println("\n===== ADMIN LOGIN =====");

                    System.out.print("Admin Email: ");
                    String adminEmail = input.nextLine();

                    System.out.print("Admin Password: ");
                    String adminPassword = input.nextLine();

                    User admin = authService.login(
                            adminEmail, adminPassword
                    );

                    if (admin instanceof Admin) {
                        adminDashboard.showDashboard();
                    } else {
                        System.out.println("Invalid Admin Account!");
                    }

                    break;

                case 4:

                    System.out.println("Thank you for using the system!");

                    input.close();
                    return;

                default:

                    System.out.println("Invalid choice!");
            }
        }
    }
}