import course.Course;
import java.util.Scanner;
import student.Student;

public class MainFile{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Registered Course: ");
        String course = scanner.nextLine();

        System.out.print("Enter Course Code: ");
        String code = scanner.nextLine();
        System.out.print("Enter Course Title: ");
        String title = scanner.nextLine();

        Student student = new Student(id, name, course);
        Course cObj = new Course(code, title);

        System.out.println();
        student.displayStudentInfo();
        System.out.println();
        cObj.displayCourseInfo();
        
        scanner.close();
    }
}