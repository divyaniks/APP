import javax.swing.*;
import java.awt.*;

public class UserLoginPreferences extends JFrame {

    JTextField username;
    JPasswordField password;

    JCheckBox rememberMe;
    JCheckBox notifications;

    JButton login;

    UserLoginPreferences() {

        setTitle("User Login");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Username
        add(new JLabel("Username:"));

        username = new JTextField();
        add(username);

        // Password
        add(new JLabel("Password:"));

        password = new JPasswordField();
        add(password);

        // Preferences
        add(new JLabel("Preferences:"));

        JPanel panel = new JPanel();

        rememberMe = new JCheckBox("Remember Me");
        notifications = new JCheckBox("Receive Notifications");

        panel.add(rememberMe);
        panel.add(notifications);

        add(panel);

        // Login button
        add(new JLabel(""));

        login = new JButton("Login");
        add(login);

        login.addActionListener(e -> {

            String user = username.getText();
            String pass = new String(password.getPassword());

            if (user.equals("admin") && pass.equals("admin123")) {

                JOptionPane.showMessageDialog(
                    this,
                    "Login Successful!\n"
                    + "Username: " + user
                    + "\nRemember Me: "
                    + rememberMe.isSelected()
                    + "\nReceive Notifications: "
                    + notifications.isSelected()
                );

            } else {

                JOptionPane.showMessageDialog(
                    this,
                    "Invalid username or password."
                );
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UserLoginPreferences();
    }
}
