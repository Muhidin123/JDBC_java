package muhidinCliProjectJava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;
    @BeforeEach
    public void setUp() throws Exception{
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Should work with simple multiplication")
    public void testMultiply () {
    assertEquals(20, calculator.multiply(4,5), "REGULAR MULTIPLICATION SHOULD WORK");
    }

    @Test
    @DisplayName("SHOULD WORK WITH SIMPLE DIVIDER")
    public void testDivide() {
        assertEquals(4, calculator.divide(8,2), "DOES NOT WORK WITH SIMPLPE DIVIDER");
    }

    @Test
    @DisplayName("SHOULD WORK WITH SIMPLE ADD FUNCTION")
    public void testAdd() {
        assertEquals(2, calculator.add(1, 1), "DOES NOT WORK WITH SIMPLE DIVIDER");
    }
}