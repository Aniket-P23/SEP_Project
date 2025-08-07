package sep_project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArccosCalculatorGuiTest {

  private ArccosCalculatorGui calculator;

  @BeforeEach
  public void setUp() {
    calculator = new ArccosCalculatorGui();
  }

  @Test
  public void testArccosZero() {
    double x = 0.0;
    double expected = Math.acos(x);
    double arcsin = calculator.computeArcsin(x, 15);
    double actual = Math.PI / 2 - arcsin;
    assertEquals(expected, actual, 0.01, "arccos(0.0) should be close to Math.acos(0.0)");
  }

  @Test
  public void testArccosHalf() {
    double x = 0.5;
    double expected = Math.acos(x);
    double arcsin = calculator.computeArcsin(x, 15);
    double actual = Math.PI / 2 - arcsin;
    assertEquals(expected, actual, 0.01, "arccos(0.5) should be close to Math.acos(0.5)");
  }

  @Test
  public void testArccosNegativeHalf() {
    double x = -0.5;
    double expected = Math.acos(x);
    double arcsin = calculator.computeArcsin(x, 15);
    double actual = Math.PI / 2 - arcsin;
    assertEquals(expected, actual, 0.01, "arccos(-0.5) should be close to Math.acos(-0.5)");
  }

  @Test
  public void testComputeArcsinAtBounds() {
    // At x = 1.0 (boundary)
    double arcsin1 = calculator.computeArcsin(1.0, 15);
    assertTrue(arcsin1 <= Math.PI / 2 && arcsin1 >= 1.0, "arcsin(1.0) should be <= PI/2");

    // At x = -1.0 (boundary)
    double arcsinMinus1 = calculator.computeArcsin(-1.0, 15);
    assertTrue(arcsinMinus1 >= -Math.PI / 2 && arcsinMinus1 <= -1.0, "arcsin(-1.0) should be >= -PI/2");
  }
}
