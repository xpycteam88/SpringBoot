package pro.sky.java.course2.calculator.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.calculator.exceptions.DivideByZeroException;
import pro.sky.java.course2.calculator.exceptions.NullValueException;

@Service
public class CalculationsImpl implements Calculations {
    @Override
    public String greeting() {
        return "Добро пожаловать в калькулятор";
    }

    @Override
    public Integer plus(Integer a, Integer b) {
        checkValue(a, b);
        return a + b;
    }

    @Override
    public Integer minus(Integer a, Integer b) {
        checkValue(a, b);
        return a - b;
    }

    @Override
    public Integer multiply(Integer a, Integer b) {
        checkValue(a, b);
        return a * b;
    }

    @Override
    public Integer divide(Integer a, Integer b) {
        checkValue(a, b);
        if(b == 0) {
            throw new DivideByZeroException("You can't divide by zero");
        }
        return a / b;
    }

    @Override
    public void checkValue(Integer a, Integer b) {
        if (a == null || b == null) {
            throw new NullValueException("One of the values is null");
        }
    }

}
