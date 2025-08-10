package sep_project;


import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


/**
 * A simple GUI-based calculator that computes arccos(x) using
 * the Maclaurin series approximation.
 *
 * <p>Accepts values between -1 and 1 from the user and displays
 * the result in radians.
 *
 * @author Aniket
 * @version 1.2.0
 */
public class ArccosCalculatorGui extends JFrame implements ActionListener {

  private final JTextField inputField;
  private final JLabel resultLabel;
  private final JButton calcButton;
  private static final String VERSION = "1.2.0";
  private static final String DEFAULT_FONT = "SansSerif";


  /** Constructs the GUI layout for the Arccos Calculator. */
  public ArccosCalculatorGui() {
    setTitle("arccos(x) Calculator — v" + VERSION);
    setSize(400, 200);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setLayout(new GridBagLayout());
    setLocationRelativeTo(null);

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.fill = GridBagConstraints.HORIZONTAL;

    JLabel promptLabel = new JLabel("Enter x (between -1 and 1): ");
    promptLabel.setFont(new Font(DEFAULT_FONT, Font.PLAIN, 14));
    gbc.gridx = 0;
    gbc.gridy = 0;
    add(promptLabel, gbc);

    inputField = new JTextField(10);
    inputField.setToolTipText("Enter a value between -1 and 1");
    inputField.setFont(new Font(DEFAULT_FONT, Font.PLAIN, 14));
    inputField.getAccessibleContext().setAccessibleName("Input Field");
    inputField.getAccessibleContext().setAccessibleDescription("Enter a value between minus one and one");
    gbc.gridx = 1;
    gbc.gridy = 0;
    add(inputField, gbc);

    calcButton = new JButton("Calculate");
    calcButton.setFont(new Font(DEFAULT_FONT, Font.BOLD, 14));
    calcButton.getAccessibleContext().setAccessibleName("Calculate Button");
    calcButton.getAccessibleContext().setAccessibleDescription("Click to calculate arccos of the entered value");
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 2;
    add(calcButton, gbc);

    resultLabel = new JLabel("");
    resultLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
    resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
    resultLabel.getAccessibleContext().setAccessibleName("Result Display");
    resultLabel.getAccessibleContext().setAccessibleDescription("Displays the arccos calculation result in radians");
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = 2;
    add(resultLabel, gbc);

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
    } catch (NumberFormatException ignored) {
      resultLabel.setText("Invalid input. Please enter a real number.");
    }
  }

  /**
   * Computes arcsin(x) using the Maclaurin series expansion.
   *
   * @param x input value
   * @param terms number of terms in the series
   * @return approximate arcsin(x)
   */
  public double computeArcsin(double x, int terms) {
    double result = 0.0;
    for (int n = 0; n < terms; n++) {
      double numerator = factorial(2 * n);
      double denominator =
          Math.pow(4, n) * Math.pow(factorial(n), 2) * (2 * n + 1);
      result += (numerator / denominator) * Math.pow(x, 2 * n + 1);
    }
    return result;
  }

  /**
   * Computes factorial of a number.
   *
   * @param num input integer
   * @return factorial of num
   */
  public double factorial(int num) {
    double result = 1.0;
    for (int i = 2; i <= num; i++) {
      result *= i;
    }
    return result;
  }
  /**
   * The main method to launch the GUI application.
   *
   * @param args command-line arguments (not used)
   */

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      ArccosCalculatorGui gui = new ArccosCalculatorGui();
      gui.calcButton.addActionListener(gui);
      gui.setVisible(true);
    });
  }
}
