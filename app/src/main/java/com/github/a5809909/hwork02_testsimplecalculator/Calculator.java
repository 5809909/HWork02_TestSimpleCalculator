package com.github.a5809909.hwork02_testsimplecalculator;

public class Calculator implements ICalculator {
    public static final String CANNOT_DIVIDE = "Cannot DIVIDE!";

    @Override
    public String addition(String firstNumber, String secondNumber) {
        return String.valueOf(Float.parseFloat(firstNumber) + Float.parseFloat(secondNumber));
    }

    @Override
    public String subtraction(String firstNumber, String secondNumber) {
        return String.valueOf(Float.parseFloat(firstNumber) - Float.parseFloat(secondNumber));
    }

    @Override
    public String division(String firstNumber, String secondNumber) {

        if (Integer.parseInt(secondNumber) == 0) {
            return CANNOT_DIVIDE;
        } else
            return String.valueOf(Float.parseFloat(firstNumber) / Float.parseFloat(secondNumber));
    }

    @Override
    public String multiply(String firstNumber, String secondNumber) {
        return String.valueOf(Float.parseFloat(firstNumber) * Float.parseFloat(secondNumber));
    }
}
