package com.example.calculator;

import com.example.calculator.utils.StringBufferUtils;
import com.example.calculator.utils.StringUtils;

import java.util.List;

public class CalculatorImpl implements Calculator {

    @Override
    public String deleteButton(String expression) {
        StringBuffer sbExpression = new StringBuffer(expression);

        if (StringBufferUtils.isEmpty(sbExpression)) {
            return "";
        }

        sbExpression.deleteCharAt(sbExpression.length() - 1);
        return sbExpression.toString();
    }

    @Override
    public String clearButton() {
        return "";
    }

    @Override
    public String operandOrOperationButton(String btnName, String expression) {
        expression = inputQualifier(expression, btnName);

        if (expression == null) {
            return null;
        }

        expression += btnName;
        return expression;
    }

    @Override
    public String percentButton(String expression) {
        StringExpression stringExpression = new StringExpressionImpl();
        List<String> listExpression = stringExpression.toList(expression);
        double lastElement = Double.parseDouble(listExpression.get(listExpression.size() - 1));
        listExpression.remove(listExpression.size() - 1);
        ArithmeticOperations arithmeticOperations = new ArithmeticOperationsImpl();
        lastElement = arithmeticOperations.percent(lastElement);
        listExpression.add(String.valueOf(lastElement));
        expression = stringExpression.toString(listExpression);
        return expression;
    }

    @Override
    public String equalsButton(String expression) {
        PostfixExpression postfixExpression = new PostfixExpressionImpl();
        List<String> listExpression = postfixExpression.convertToPostfixExpression(expression);
        double result;

        try {
            result = postfixExpression.solvePostfixExpression(listExpression);
        } catch (ArithmeticException exception) {
            return exception.getMessage();
        }

        return String.valueOf(result);
    }

    private String inputQualifier(String expression, String btnName) {
        if (expression.isEmpty()) {
            if (btnName.equals("0")) {
                return null;
            }

            if (!StringUtils.isNumeric(btnName)) {
                return "0";
            }
        } else {
            char lastElement = expression.charAt(expression.length() - 1);

            if (Character.isDigit(lastElement)) {
                return expression;
            }

            if (btnName.equals(".")) {
                return expression + "0";
            }

            if (!StringUtils.isNumeric(btnName)) {
                return deleteButton(expression);
            }
        }

        return expression;
    }
}
