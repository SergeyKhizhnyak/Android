package com.example.calculator;

import java.util.List;

public class CalculatorImpl implements Calculator {

    @Override
    public String deleteButton(String str) {
        StringBuffer calculation = new StringBuffer(str);

        if (StringBufferUtils.isEmpty(calculation)) {
            return "";
        }

        calculation.deleteCharAt(calculation.length() - 1);
        return calculation.toString();
    }

    @Override
    public String clearButton() {
        return "";
    }

    @Override
    public String operandOrOperationButton(String btnName, String calculation) {
        calculation = inputQualifier(calculation, btnName);

        if (calculation == null) {
            return null;
        }

        calculation += btnName;
        return calculation;
    }

    @Override
    public String percentButton(String str) {
        StringExpression stringExpression = new StringExpressionImpl();
        List<String> expression = stringExpression.toList(str);
        double lastElement = Double.parseDouble(expression.get(expression.size() - 1));
        expression.remove(expression.size() - 1);
        ArithmeticOperations arithmeticOperations = new ArithmeticOperationsImpl();
        lastElement = arithmeticOperations.percent(lastElement);
        expression.add(String.valueOf(lastElement));
        str = stringExpression.toString(expression);
        return str;
    }

    @Override
    public String equalsButton(String expression) {
        PostfixExpression postfixExpression = new PostfixExpression();
        List<String> listExpression = postfixExpression.convertToPostfixExpression(expression);
        double result;

        try {
            result = postfixExpression.solvePostfixExpression(listExpression);
        } catch (ArithmeticException exception) {
            return exception.getMessage();
        }

        return String.valueOf(result);
    }

    private String inputQualifier(String str, String btnName) {
        if (str.isEmpty()) {
            if (btnName.equals("0")) {
                return null;
            }

            if (!StringUtils.isNumeric(btnName)) {
                return "0";
            }
        } else {
            char lastElement = str.charAt(str.length() - 1);

            if (Character.isDigit(lastElement)) {
                return str;
            }

            if (btnName.equals(".")) {
                return str + "0";
            }

            if (!StringUtils.isNumeric(btnName)) {
                return deleteButton(str);
            }
        }

        return str;
    }
}
