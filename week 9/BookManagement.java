import java.sql.*;
import java.util.Scanner;

public class BookManagement {

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

            while (true) {

                System.out.println("\n===== BOOK MANAGEMENT =====");
                System.out.println("1. Insert Book");
                System.out.println("2. Search Book");
                System.out.println("3. Display Available Books");
                System.out.println("4. Issue Book");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        insertBook(con, sc);
                        break;

                    case 2:
                        searchBook(con, sc);
                        break;

                    case 3:
                        displayAvailableBooks(con);
                        break;

                    case 4:
                        issueBook(con, sc);
                        break;

                    case 5:
                        System.out.println("Program ended.");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            }

        } catch (SQLException e) {
            System.out.println("Database error:");
            e.printStackTrace();
        }
    }

    // Insert a new book
    static void insertBook(Connection con, Scanner sc)
            throws SQLException {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        String sql =
                "INSERT INTO Book " +
                "(BookID, Title, Author, Price, Availability) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setDouble(4, price);
            ps.setBoolean(5, true);

            ps.executeUpdate();

            System.out.println("Book inserted successfully!");
        }
    }

    // Search book by ID
    static void searchBook(Connection con, Scanner sc)
            throws SQLException {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        String sql =
                "SELECT * FROM Book WHERE BookID = ?";

        try (PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    System.out.println("\nBook Details");
                    System.out.println("Book ID: "
                            + rs.getInt("BookID"));

                    System.out.println("Title: "
                            + rs.getString("Title"));

                    System.out.println("Author: "
                            + rs.getString("Author"));

                    System.out.println("Price: "
                            + rs.getDouble("Price"));

                    System.out.println("Available: "
                            + rs.getBoolean("Availability"));

                } else {
                    System.out.println("Book not found.");
                }
            }
        }
    }

    // Display available books
    static void displayAvailableBooks(Connection con)
            throws SQLException {

        String sql =
                "SELECT * FROM Book WHERE Availability = TRUE";

        try (PreparedStatement ps =
                     con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n===== AVAILABLE BOOKS =====");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println(
                        rs.getInt("BookID")
                        + " | "
                        + rs.getString("Title")
                        + " | "
                        + rs.getString("Author")
                        + " | Rs."
                        + rs.getDouble("Price"));
            }

            if (!found) {
                System.out.println("No available books.");
            }
        }
    }

    // Issue a book
    static void issueBook(Connection con, Scanner sc)
            throws SQLException {

        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();

        String sql =
                "UPDATE Book SET Availability = FALSE " +
                "WHERE BookID = ? AND Availability = TRUE";

        try (PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println(
                        "Book issued successfully!");
            } else {
                System.out.println(
                        "Book not found or already issued.");
            }
        }
    }
}