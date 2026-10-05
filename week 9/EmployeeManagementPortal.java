
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Employee {
    String id, name, department;

    Employee(String id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public String toString() {
        return id + " | " + name + " | " + department;
    }
}

class EmployeeModel {
    String username = "admin";
    String password = "admin123";
    ArrayList<Employee> employees = new ArrayList<>();

    boolean login(String u, String p) {
        return username.equals(u) && password.equals(p);
    }

    boolean changePassword(String oldP, String newP, String confirm) {
        if (password.equals(oldP) && !newP.isEmpty()
                && newP.equals(confirm)) {
            password = newP;
            return true;
        }
        return false;
    }

    void addEmployee(String id, String name, String dept) {
        employees.add(new Employee(id, name, dept));
    }
}

public class EmployeeManagementPortal {
    static EmployeeModel model = new EmployeeModel();

    static void showLogin() {
        JFrame f = new JFrame("Employee Login");
        JTextField user = new JTextField();
        JPasswordField pass = new JPasswordField();
        JButton login = new JButton("Login");

        f.setLayout(new GridLayout(3, 2, 5, 5));
        f.add(new JLabel("Username:")); f.add(user);
        f.add(new JLabel("Password:")); f.add(pass);
        f.add(new JLabel()); f.add(login);

        login.addActionListener(e -> {
            if (model.login(user.getText(),
                    new String(pass.getPassword()))) {
                f.dispose();
                showMain();
            } else {
                JOptionPane.showMessageDialog(f,
                    "Invalid username or password.");
            }
        });

        f.setSize(320, 160);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    static void showMain() {
        JFrame f = new JFrame("Employee Management Portal");
        JMenuBar bar = new JMenuBar();

        JMenu employee = new JMenu("Employee");
        JMenuItem add = new JMenuItem("Add Employee");
        JMenuItem view = new JMenuItem("View Employee");
        employee.add(add);
        employee.add(view);

        JMenu tools = new JMenu("Tools");
        JMenuItem change = new JMenuItem("Change Password");
        tools.add(change);

        JMenu exit = new JMenu("Exit");
        JMenuItem logout = new JMenuItem("Logout");
        JMenuItem quit = new JMenuItem("Exit Application");
        exit.add(logout);
        exit.add(quit);

        bar.add(employee);
        bar.add(tools);
        bar.add(exit);
        f.setJMenuBar(bar);

        add.addActionListener(e -> {
            JTextField id = new JTextField();
            JTextField name = new JTextField();
            JTextField dept = new JTextField();

            Object[] fields = {
                "Employee ID:", id,
                "Employee Name:", name,
                "Department:", dept
            };

            int result = JOptionPane.showConfirmDialog(
                f, fields, "Add Employee",
                JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                if (id.getText().trim().isEmpty()
                        || name.getText().trim().isEmpty()
                        || dept.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(f,
                        "All fields are required.");
                    return;
                }

                model.addEmployee(id.getText(), name.getText(),
                                  dept.getText());
                JOptionPane.showMessageDialog(f,
                    "Employee added successfully.");
            }
        });

        view.addActionListener(e -> {
            StringBuilder s = new StringBuilder();
            for (Employee emp : model.employees)
                s.append(emp).append("\n");

            JOptionPane.showMessageDialog(f,
                s.length() == 0 ? "No employees found." : s.toString());
        });

        change.addActionListener(e -> {
            JPasswordField oldP = new JPasswordField();
            JPasswordField newP = new JPasswordField();
            JPasswordField confirm = new JPasswordField();

            Object[] fields = {
                "Old Password:", oldP,
                "New Password:", newP,
                "Confirm Password:", confirm
            };

            int result = JOptionPane.showConfirmDialog(
                f, fields, "Change Password",
                JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                boolean ok = model.changePassword(
                    new String(oldP.getPassword()),
                    new String(newP.getPassword()),
                    new String(confirm.getPassword()));

                JOptionPane.showMessageDialog(f, ok
                    ? "Password changed successfully."
                    : "Incorrect old password or passwords do not match.");
            }
        });

        logout.addActionListener(e -> {
            f.dispose();
            showLogin();
        });

        quit.addActionListener(e -> System.exit(0));

        f.setSize(500, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EmployeeManagementPortal::showLogin);
    }
}