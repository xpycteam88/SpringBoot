package pro.sky.java.course2.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.calculator.service.Calculations;

@RestController
@RequestMapping(path = "/calculator")
public class Calculator {

    private final Calculations calculator;

    public Calculator(Calculations calculator) {
        this.calculator = calculator;
    }

    @GetMapping
    public String showGreeting() {
        return calculator.greeting();
    }

    @GetMapping(path = "/plus")
    public String plus(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        // реализовал здесь проверку на null
        if (calculator.thereValue(num1, num2)) {
            return "Не введено значение!!!";
        } else {
            return "Сумма чисел " + num1 + " и " + num2 + " = " + calculator.plus(num1, num2);

        }
    }

    @GetMapping(path = "/minus")
    public String minus(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (calculator.thereValue(num1, num2)) {
            return "Не введено значение!!!";
        } else {
            return "Вычитание чисел " + num1 + " и " + num2 + " = " + calculator.minus(num1, num2);
        }
    }

    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (calculator.thereValue(num1, num2)) {
            return "Не введено значение!!!";
        } else {
            return "Умножение чисел " + num1 + " на " + num2 + " = " + calculator.multiply(num1, num2);
        }
    }

    @GetMapping(path = "/divide")
    public String divide(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (calculator.thereValue(num1, num2)) {
            return "Не введено значение!!!";
        } else {
            if (num2 != 0) {
                return "Деление чисел " + num1 + " на " + num2 + " = " + calculator.divide(num1, num2);
            } else {
                return "На ноль делить НЕЛЬЗЯ!";
            }
        }
    }

}
