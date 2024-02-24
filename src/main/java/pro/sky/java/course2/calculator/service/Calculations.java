package pro.sky.java.course2.calculator.service;

public interface Calculations {
    String greeting();

    Integer plus(Integer a, Integer b);

    Integer minus(Integer a, Integer b);

    Integer multiply(Integer a, Integer b);

    Integer divide(Integer a, Integer b);

    void checkValue(Integer a, Integer b);

}
