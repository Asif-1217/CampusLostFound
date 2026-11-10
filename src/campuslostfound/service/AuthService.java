package campuslostfound.service;

import campuslostfound.model.User;
import campuslostfound.model.Student;
import campuslostfound.repository.UserRepository;

public class AuthService {

    private UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerStudent(int userId, String name,
                                String email, String password,
                                String studentId, String department) {

        if (userRepository.findUserByEmail(email) != null) {
            System.out.println("Email already registered!");
            return;
        }

        Student student = new Student(
                userId, name, email, password,
                studentId, department
        );

        userRepository.addUser(student);
    }

    public User login(String email, String password) {

        User user = userRepository.findUserByEmail(email);

        if (user != null && user.verifyPassword(password)) {
            System.out.println("Login successful!");
            return user;
        }

        System.out.println("Invalid email or password!");
        return null;
    }
}