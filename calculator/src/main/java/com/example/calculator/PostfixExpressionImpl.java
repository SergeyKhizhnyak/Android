package com.example.calculator;

import com.example.calculator.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostfixExpressionImpl implements PostfixExpression{

    public List<String> convertToPostfixExpression(String strExpression) {
        StringExpression stringExpression = new StringExpressionImpl();
        List<String> expression = stringExpression.toList(strExpression);
        List<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for (String element : expression) {
            if (StringUtils.isNumeric(element)) {
                result.add(element);
                continue;
            }

            while (!stack.isEmpty() && precedence(element) <= precedence(stack.peek())) {
                result.add(stack.pop());
            }

            stack.push(element);
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    public double solvePostfixExpression(List<String> expression) {
        ArithmeticOperations arithmeticOperations = new ArithmeticOperationsImpl();
        Stack<Double> stack = new Stack<>();

        if (expression.size() < 3) {
            String firstElement = expression.get(0);
            return Double.parseDouble(firstElement);
        }

        for (String element : expression) {
            if (StringUtils.isNumeric(element)) {
                stack.push(Double.parseDouble(element));
                continue;
            }

            double right = stack.pop();
            double left = stack.pop();

            switch (element) {
                case ("+"):
                    stack.push(arithmeticOperations.addition(left, right));
                    break;
                case ("-"):
                    stack.push(arithmeticOperations.subtraction(left, right));
                    break;
                case ("*"):
                    stack.push(arithmeticOperations.multiplication(left, right));
                    break;
                case ("/"):
                    stack.push(arithmeticOperations.division(left, right));
            }
        }

        return stack.pop();
    }

    private int precedence(String str) {
        if (str.equals("+") || str.equals("-")) {
            return 1;
        }

        if (str.equals("*") || str.equals("/")) {
            return 2;
        }

        return -1;
    }
}
