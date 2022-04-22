package com.example.calculator;

import java.math.BigDecimal;

public class ArithmeticOperationsImpl implements ArithmeticOperations {

    @Override
    public double addition(double left, double right) {
        return left + right;
    }

    @Override
    public double subtraction(double left, double right) {
        BigDecimal result = BigDecimal.valueOf(left).subtract(BigDecimal.valueOf(right));
        return result.doubleValue();
    }

    @Override
    public double multiplication(double left, double right) {
        return left * right;
    }

    @Override
    public double division(double left, double right) {
        double result = left / right;

        if (result == Double.POSITIVE_INFINITY ||
                result == Double.NEGATIVE_INFINITY ||
                Double.isNaN(result)) {
            throw new ArithmeticException("Cant`t divide by zero");
        }

        return result;
    }

    @Override
    public double percent(double value) {
        return value / 100;
    }
}
