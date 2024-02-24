package pro.sky.java.course2.calculator.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.java.course2.calculator.exceptions.DivideByZeroException;
import pro.sky.java.course2.calculator.exceptions.NullValueException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ParamCalculationsImplTest {
    CalculationsImpl out = new CalculationsImpl();

    public static Stream<Arguments> paramTest() {
        return Stream.of(
                Arguments.of(5, 5),
                Arguments.of(5, 0),
                Arguments.of(0, 5),
                Arguments.of(0, 0),
                Arguments.of(-5, 5),
                Arguments.of(-5, -5),
                Arguments.of(0, -5),
                Arguments.of(-5, 0),
                Arguments.of(null, null),
                Arguments.of(null, 5),
                Arguments.of(5, null)
        );

    }

    @ParameterizedTest
    @MethodSource("paramTest")
    void plusParamTest(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            assertThrows(NullValueException.class, () -> out.checkValue(num1, num2));
            return;
        }
        assertEquals(num1 + num2, out.plus(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("paramTest")
    void minusParamTest(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            assertThrows(NullValueException.class, () -> out.checkValue(num1, num2));
            return;
        }
        assertEquals(num1 - num2, out.minus(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("paramTest")
    void multiplyParamTest(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            assertThrows(NullValueException.class, () -> out.checkValue(num1, num2));
            return;
        }
        assertEquals(num1 * num2, out.multiply(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("paramTest")
    void divideParamTest(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            assertThrows(NullValueException.class, () -> out.checkValue(num1, num2));
            return;
        }
        if (num2 == 0) {
            assertThrows(DivideByZeroException.class, () -> out.divide(num1, num2));
            return;
        }
        assertEquals(num1 / num2, out.divide(num1, num2));
    }

    @Test
    void checkValueNullTest() {
        assertThrows(NullValueException.class, () -> out.checkValue(null, null));
    }
}