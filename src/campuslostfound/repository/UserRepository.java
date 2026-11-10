package campuslostfound.repository;

import campuslostfound.model.User;
import java.util.ArrayList;

public class UserRepository {

    private ArrayList<User> users = new ArrayList<>();

    public void addUser(User user) {

        for (User existingUser : users) {
            if (existingUser.getEmail().equalsIgnoreCase(user.getEmail())) {
                System.out.println("Email already exists!");
                return;
            }
        }

        users.add(user);
        System.out.println("User registered successfully!");
    }

    public User findUserByEmail(String email) {

        for (User user : users) {

            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }

        return null;
    }

    public void displayAllUsers() {

        for (User user : users) {
            System.out.println("ID: " + user.getUserId());
            System.out.println("Name: " + user.getName());
            System.out.println("Email: " + user.getEmail());
            System.out.println("--------------------");
        }
    }
}