import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StudentCourseManagement extends JFrame {

    JList<String> courseList;
    JTable table;

    DefaultTableModel model;

    JButton addButton;
    JButton removeButton;

    StudentCourseManagement() {

        setTitle("Student Course Management");
        setSize(700, 450);
        setLayout(new BorderLayout(10, 10));

        // Available courses
        String[] courses = {
            "Java Programming",
            "Database Management",
            "Computer Networks",
            "Operating Systems",
            "Web Development"
        };

        courseList = new JList<>(courses);

        JScrollPane courseScroll =
            new JScrollPane(courseList);

        courseScroll.setBorder(
            BorderFactory.createTitledBorder(
                "Available Courses"
            )
        );

        // Table
        String[] columns = {
            "Student Name",
            "Selected Course",
            "Enrollment Status"
        };

        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);

        JScrollPane tableScroll =
            new JScrollPane(table);

        tableScroll.setBorder(
            BorderFactory.createTitledBorder(
                "Course Registrations"
            )
        );

        // Buttons
        addButton = new JButton("Add Course");
        removeButton = new JButton("Remove Course");

        JPanel buttonPanel = new JPanel();

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        // Add course
        addButton.addActionListener(e -> {

            String course =
                courseList.getSelectedValue();

            if (course == null) {

                JOptionPane.showMessageDialog(
                    this,
                    "Please select a course."
                );

                return;
            }

            String name = JOptionPane.showInputDialog(
                this,
                "Enter Student Name:"
            );

            if (name != null && !name.trim().isEmpty()) {

                model.addRow(
                    new Object[]{
                        name,
                        course,
                        "Enrolled"
                    }
                );
            }
        });

        // Remove course
        removeButton.addActionListener(e -> {

            int row = table.getSelectedRow();

            if (row == -1) {

                JOptionPane.showMessageDialog(
                    this,
                    "Please select a registration."
                );

                return;
            }

            model.removeRow(row);
        });

        add(courseScroll, BorderLayout.WEST);
        add(tableScroll, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentCourseManagement();
    }
}