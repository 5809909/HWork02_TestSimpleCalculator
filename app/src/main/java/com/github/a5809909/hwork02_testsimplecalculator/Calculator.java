package com.github.a5809909.hwork02_testsimplecalculator;

public class Calculator implements ICalculator {

    @Override
    public String addition(String num1, String num2) {
        return String.valueOf(Float.parseFloat(num1)+Float.parseFloat(num2));
    }

    @Override
    public String subtraction(String num1, String num2) {
        return String.valueOf(Float.parseFloat(num1)-Float.parseFloat(num2));
    }

    @Override
    public String division(String num1, String num2) {
        if (Integer.parseInt(num2)==0){return "Cannot DIVIDE!";} else
        return String.valueOf(Float.parseFloat(num1)/Float.parseFloat(num2));
    }

    @Override
    public String multiply(String num1, String num2) {
        return String.valueOf(Float.parseFloat(num1)*Float.parseFloat(num2));
    }
}
