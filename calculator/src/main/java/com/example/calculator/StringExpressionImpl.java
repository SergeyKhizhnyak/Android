package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

public class StringExpressionImpl implements StringExpression {

    @Override
    public List<String> toList(String expression) {
        List<String> result = new ArrayList<>();
        StringBuilder number = new StringBuilder();

        for (char element : expression.toCharArray()) {
            if (Character.isDigit(element) || element == '.') {
                number.append(element);
                continue;
            }

            result.add(number.toString());
            result.add(String.valueOf(element));
            number = new StringBuilder();
        }

        if (number.length() != 0) {
            result.add(number.toString());
        }

        return result;
    }

    @Override
    public String toString(List<String> expression) {
        StringBuilder result = new StringBuilder();

        for (String element : expression) {
            result.append(element);
        }

        return result.toString();
    }
}
