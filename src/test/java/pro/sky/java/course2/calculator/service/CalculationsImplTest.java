package pro.sky.java.course2.calculator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.calculator.exceptions.DivideByZeroException;
import pro.sky.java.course2.calculator.exceptions.NullValueException;

import static org.junit.jupiter.api.Assertions.*;

public class CalculationsImplTest {
    private static Integer num0;
    private static Integer num1;
    private static Integer num2;

    private CalculationsImpl out;

    @BeforeEach
    public void setUp() {
        num0 = 0;
        num1 = 5;
        num2 = 5;
        out = new CalculationsImpl();
    }

    @Test
    public void greetingTest() {
        assertEquals("Добро пожаловать в калькулятор", out.greeting());
    }

    @Test
    public void plusTest() {
        Integer expected = num1 + num2;
        Integer actual = out.plus(num1, num2);
        assertEquals(expected, actual);
    }

    @Test
    public void minusTest() {
        Integer expected = num1 - num2;
        Integer actual = out.minus(num1, num2);
        assertEquals(expected, actual);
    }

    @Test
    public void multiplyTest() {
        Integer expected = num1 * num2;
        Integer actual = out.multiply(num1, num2);
        assertEquals(expected, actual);
    }

    @Test
    public void divideTest() {
        Integer expected = num1 / num2;
        Integer actual = out.divide(num1, num2);
        assertEquals(expected, actual);
    }

    @Test
    public void divideByZeroTest() {
        assertThrows(DivideByZeroException.class, () -> out.divide(num1, num0));
    }

    @Test
    public void nullValueTest() {
        assertThrows(NullValueException.class, () -> out.checkValue(null, null));
    }

}
