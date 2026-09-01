import course.Course;
import student.Student;

public class Main {
    public static void main(String[] args) {

        Student student = new Student(
            "Rahul",
            101,
            "Computer Science"
        );

        Course course = new Course(
            "Java Programming",
            "CS101",
            4
        );

        student.displayStudent();

        System.out.println();

        course.displayCourse();
    }
}