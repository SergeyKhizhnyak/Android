package com.example.calculator;

import java.util.List;

public interface PostfixExpression {

    List<String> convertToPostfixExpression(String strExpression);

    double solvePostfixExpression(List<String> expression);
}
