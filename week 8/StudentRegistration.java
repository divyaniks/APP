import javax.swing.*;
import java.awt.*;

public class StudentRegistration extends JFrame {

    JTextField nameField;
    JTextField regField;

    JRadioButton male;
    JRadioButton female;

    JComboBox<String> department;

    JButton submit;

    StudentRegistration() {

        setTitle("Student Registration System");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Student Name
        add(new JLabel("Student Name:"));
        nameField = new JTextField();
        add(nameField);

        // Register Number
        add(new JLabel("Register Number:"));
        regField = new JTextField();
        add(regField);

        // Gender
        add(new JLabel("Gender:"));

        JPanel genderPanel = new JPanel();

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        genderPanel.add(male);
        genderPanel.add(female);

        add(genderPanel);

        // Department
        add(new JLabel("Department:"));

        department = new JComboBox<>(
            new String[]{
                "CSE",
                "ECE",
                "EEE",
                "MECH",
                "CIVIL"
            }
        );

        add(department);

        // Submit button
        submit = new JButton("Submit");
        add(new JLabel(""));
        add(submit);

        submit.addActionListener(e -> {

            String name = nameField.getText();
            String reg = regField.getText();

            String gender = "";

            if (male.isSelected()) {
                gender = "Male";
            } else if (female.isSelected()) {
                gender = "Female";
            } else {
                gender = "Not Selected";
            }

            String dept =
                department.getSelectedItem().toString();

            JOptionPane.showMessageDialog(
                this,
                "Student Registration Details\n\n"
                + "Name: " + name + "\n"
                + "Register Number: " + reg + "\n"
                + "Gender: " + gender + "\n"
                + "Department: " + dept
            );
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }
}