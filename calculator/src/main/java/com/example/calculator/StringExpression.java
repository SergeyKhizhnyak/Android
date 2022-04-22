package com.example.calculator;

import java.util.List;

public interface StringExpression {
    List<String> toList(String expression);

    String toString(List<String> expression);
}
