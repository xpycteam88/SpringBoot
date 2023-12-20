package pro.sky.java.course2.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculationsImpl implements Calculations {
    @Override
    public String greeting() {
        return "Добро пожаловать в калькулятор";
    }

    @Override
    public Integer plus(Integer a, Integer b) {
        int i = a + b;
        return i;
    }

    @Override
    public Integer minus(Integer a, Integer b) {
        int i = a - b;
        return i;
    }

    @Override
    public Integer multiply(Integer a, Integer b) {
        int i = a * b;
        return i;
    }

    @Override
    public Double divide(Integer a, Integer b) {
        double i = a / b;
        return i;
    }

    @Override
    public boolean thereValue(Integer a, Integer b) {
        if (a == null || b == null) {
            return true;
        } else {
            return false;
        }
    }

}
