package com.example.calculator;

public interface Calculator {
    String deleteButton(String expression);

    String clearButton();

    String percentButton(String expression);

    String operandOrOperationButton(String btnName, String calculation);

    String equalsButton(String expression);
}
