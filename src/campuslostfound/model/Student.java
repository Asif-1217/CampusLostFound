package campuslostfound.model;

public class Student extends User {

    private String studentId;
    private String department;

    public Student(int userId, String name, String email,
                   String password, String studentId, String department) {

        super(userId, name, email, password);

        this.studentId = studentId;
        this.department = department;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public void displayDashboard() {
        System.out.println("Welcome Student!");
        System.out.println("Name: " + getName());
        System.out.println("Student ID: " + studentId);
        System.out.println("Department: " + department);
    }
}