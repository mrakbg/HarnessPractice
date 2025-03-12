import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void testAddition() {
        Calculator calc = new Calculator();
        assertEquals(15, calc.add(10, 5));
        assertEquals(0, calc.add(-2, 2));
        assertEquals(100, calc.add(50, 50));
    }

    @Test
    void testSubtraction() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.subtract(10, 5));
        assertEquals(-4, calc.subtract(2, 6));
        assertEquals(0, calc.subtract(20, 20));
    }

    @Test
    void testMultiplication() {
        Calculator calc = new Calculator();
        assertEquals(50, calc.multiply(10, 5));
        assertEquals(0, calc.multiply(0, 5));
        assertEquals(-6, calc.multiply(-2, 3));
    }
}
