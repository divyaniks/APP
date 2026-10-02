import java.sql.*;
import java.util.Scanner;

public class ProductManagement {

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

                System.out.println("\n===== PRODUCT MANAGEMENT =====");
                System.out.println("1. Insert Product");
                System.out.println("2. Search Product");
                System.out.println("3. Update Quantity");
                System.out.println("4. Display Low Stock Products");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        insertProduct(con, sc);
                        break;

                    case 2:
                        searchProduct(con, sc);
                        break;

                    case 3:
                        updateQuantity(con, sc);
                        break;

                    case 4:
                        displayLowStock(con);
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

    // Insert product
    static void insertProduct(Connection con, Scanner sc)
            throws SQLException {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        String sql =
                "INSERT INTO Product " +
                "(ProductID, ProductName, Price, Quantity) " +
                "VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, price);
            ps.setInt(4, quantity);

            ps.executeUpdate();

            System.out.println("Product inserted successfully!");
        }
    }

    // Search product
    static void searchProduct(Connection con, Scanner sc)
            throws SQLException {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        String sql =
                "SELECT * FROM Product WHERE ProductID = ?";

        try (PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    System.out.println("\nProduct Details");

                    System.out.println("Product ID: "
                            + rs.getInt("ProductID"));

                    System.out.println("Product Name: "
                            + rs.getString("ProductName"));

                    System.out.println("Price: "
                            + rs.getDouble("Price"));

                    System.out.println("Quantity: "
                            + rs.getInt("Quantity"));

                } else {
                    System.out.println("Product not found.");
                }
            }
        }
    }

    // Update quantity
    static void updateQuantity(Connection con, Scanner sc)
            throws SQLException {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        System.out.print("Enter New Quantity: ");
        int quantity = sc.nextInt();

        if (quantity < 0) {
            System.out.println("Quantity cannot be negative.");
            return;
        }

        String sql =
                "UPDATE Product SET Quantity = ? " +
                "WHERE ProductID = ?";

        try (PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setInt(1, quantity);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println(
                        "Quantity updated successfully!");
            } else {
                System.out.println("Product not found.");
            }
        }
    }

    // Display products with quantity below 10
    static void displayLowStock(Connection con)
            throws SQLException {

        String sql =
                "SELECT * FROM Product WHERE Quantity < 10";

        try (PreparedStatement ps =
                     con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n===== LOW STOCK PRODUCTS =====");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println(
                        rs.getInt("ProductID")
                        + " | "
                        + rs.getString("ProductName")
                        + " | Rs."
                        + rs.getDouble("Price")
                        + " | Quantity: "
                        + rs.getInt("Quantity"));
            }

            if (!found) {
                System.out.println("No low-stock products.");
            }
        }
    }
}