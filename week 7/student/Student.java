package student;

public class Student {
    private int studentId;
    private String name;
    private String course;

    public Student(int studentId, String name, String course) {
        this.studentId = studentId;
        this.name = name;
        this.course = course;
    }

    public void displayStudentInfo() {
        System.out.println("--- Student Details ---");
        System.out.println("ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
    }
}