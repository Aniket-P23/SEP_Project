
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArccosCalculatorGUI extends JFrame implements ActionListener {
    private JTextField inputField;
    private JLabel resultLabel;

    public ArccosCalculatorGUI() {
        setTitle("arccos(x) Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel promptLabel = new JLabel("Enter x (between -1 and 1): ");
        inputField = new JTextField(10);
        JButton calcButton = new JButton("Calculate");
        resultLabel = new JLabel("");

        add(promptLabel);
        add(inputField);
        add(calcButton);
        add(resultLabel);

        calcButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double x = Double.parseDouble(inputField.getText());
            if (x < -1 || x > 1) {
                resultLabel.setText("Error: x must be in [-1, 1]");
                return;
            }

            double arcsin = computeArcsin(x, 15);
            double arccos = Math.PI / 2 - arcsin;
            resultLabel.setText(String.format("arccos(%.4f) = %.6f radians", x, arccos));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter a real number.");
        }
    }

    public double computeArcsin(double x, int terms) {
        double result = 0.0;
        for (int n = 0; n < terms; n++) {
            double numerator = factorial(2 * n);
            double denominator = Math.pow(4, n) * Math.pow(factorial(n), 2) * (2 * n + 1);
            result += (numerator / denominator) * Math.pow(x, 2 * n + 1);
        }
        return result;
    }

    public double factorial(int num) {
        double result = 1.0;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ArccosCalculatorGUI().setVisible(true);
        });
    }
}