
import javax.swing.*;
import java.awt.*;

class GradeModel {
    String name;
    double total, average;
    String grade;

    void calculate(String n, double a, double b, double c) {
        name = n;
        total = a + b + c;
        average = total / 3;

        if (average >= 90) grade = "A";
        else if (average >= 75) grade = "B";
        else if (average >= 60) grade = "C";
        else if (average >= 50) grade = "D";
        else grade = "F";
    }
}

class GradeView extends JFrame {
    JTextField name = new JTextField();
    JTextField m1 = new JTextField();
    JTextField m2 = new JTextField();
    JTextField m3 = new JTextField();
    JButton calculate = new JButton("Calculate Result");
    JLabel result = new JLabel("Enter details and calculate");

    GradeView() {
        setTitle("Student Grade Calculator");
        setSize(350, 300);
        setLayout(new GridLayout(6, 2, 5, 5));

        add(new JLabel("Student Name:")); add(name);
        add(new JLabel("Subject 1 Marks:")); add(m1);
        add(new JLabel("Subject 2 Marks:")); add(m2);
        add(new JLabel("Subject 3 Marks:")); add(m3);
        add(calculate); add(result);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

public class StudentGradeCalculator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GradeModel model = new GradeModel();
            GradeView view = new GradeView();

            view.calculate.addActionListener(e -> {
                try {
                    String name = view.name.getText().trim();
                    double a = Double.parseDouble(view.m1.getText());
                    double b = Double.parseDouble(view.m2.getText());
                    double c = Double.parseDouble(view.m3.getText());

                    if (name.isEmpty() || a < 0 || a > 100 ||
                        b < 0 || b > 100 || c < 0 || c > 100)
                        throw new IllegalArgumentException();

                    model.calculate(name, a, b, c);

                    view.result.setText(String.format(
                        "Total: %.0f | Avg: %.2f | Grade: %s",
                        model.total, model.average, model.grade));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(view,
                        "Enter a name and marks between 0 and 100.");
                }
            });
        });
    }
}