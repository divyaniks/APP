
import javax.swing.*;
import java.awt.*;

class ServiceModel {
    int calculateCost(boolean general, boolean oil,
                      boolean brake, boolean battery) {
        int total = 0;
        if (general) total += 1000;
        if (oil) total += 800;
        if (brake) total += 1200;
        if (battery) total += 500;
        return total;
    }
}

class ServiceView extends JFrame {
    JTextField registration = new JTextField();
    JComboBox<String> type =
        new JComboBox<>(new String[]{"Two Wheeler", "Car"});

    JCheckBox general = new JCheckBox("General Service - Rs.1000");
    JCheckBox oil = new JCheckBox("Oil Change - Rs.800");
    JCheckBox brake = new JCheckBox("Brake Service - Rs.1200");
    JCheckBox battery = new JCheckBox("Battery Check - Rs.500");

    JButton calculate = new JButton("Calculate Cost");

    ServiceView() {
        setTitle("Vehicle Service Estimator");
        setSize(400, 300);
        setLayout(new GridLayout(7, 2, 5, 5));

        add(new JLabel("Registration Number:"));
        add(registration);
        add(new JLabel("Vehicle Type:"));
        add(type);
        add(general);
        add(oil);
        add(brake);
        add(battery);
        add(calculate);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

public class VehicleServiceEstimator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ServiceModel model = new ServiceModel();
            ServiceView view = new ServiceView();

            view.calculate.addActionListener(e -> {
                if (view.registration.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(view,
                        "Enter vehicle registration number.");
                    return;
                }

                int cost = model.calculateCost(
                    view.general.isSelected(),
                    view.oil.isSelected(),
                    view.brake.isSelected(),
                    view.battery.isSelected()
                );

                JOptionPane.showMessageDialog(view,
                    "Registration: " + view.registration.getText()
                    + "\nVehicle: " + view.type.getSelectedItem()
                    + "\nTotal Service Cost: Rs. " + cost);
            });
        });
    }
}