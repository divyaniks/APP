import java.sql.*;
import java.util.Scanner;

public class CourseRegistrationSearch {

    static final String URL =
            "jdbc:mysql://localhost:3306/college";

    static final String USER = "root";

    static final String PASSWORD =
            "sql987#A";

    public static void main(String[] args) {

        try (Connection con =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner sc = new Scanner(System.in)) {

            System.out.println("Connected to MySQL successfully!");

            System.out.print("Enter Course Code: ");
            String courseCode = sc.nextLine();

            String sql =
                    "SELECT * FROM CourseRegistration " +
                    "WHERE CourseCode = ?";

            try (PreparedStatement ps =
                         con.prepareStatement(sql)) {

                ps.setString(1, courseCode);

                try (ResultSet rs = ps.executeQuery()) {

                    boolean found = false;

                    System.out.println(
                            "\n===== REGISTERED STUDENTS =====");

                    while (rs.next()) {

                        found = true;

                        System.out.println(
                                "Student ID: "
                                + rs.getInt("StudentID"));

                        System.out.println(
                                "Student Name: "
                                + rs.getString("StudentName"));

                        System.out.println(
                                "Course Code: "
                                + rs.getString("CourseCode"));

                        System.out.println(
                                "Course Name: "
                                + rs.getString("CourseName"));

                        System.out.println(
                                "Semester: "
                                + rs.getInt("Semester"));

                        System.out.println("-----------------------------");
                    }

                    if (!found) {
                        System.out.println(
                                "No students registered for "
                                + courseCode);
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Database error:");
            e.printStackTrace();
        }
    }
}