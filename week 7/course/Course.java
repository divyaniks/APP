package course;

public class Course {
    private String courseCode;
    private String courseName;

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public void displayCourseInfo() {
        System.out.println("--- Course Details ---");
        System.out.println("Code: " + courseCode);
        System.out.println("Name: " + courseName);
    }
}