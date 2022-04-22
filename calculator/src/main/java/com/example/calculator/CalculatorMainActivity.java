package com.example.calculator;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorMainActivity extends AppCompatActivity {
    Calculator calculator = new CalculatorImpl();
    TextView calculationStoryField;
    TextView calculationField;
    TextView resultField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_main);
        calculationField = findViewById(R.id.text_view_calculation_field);
        resultField = findViewById(R.id.text_view_result_field);
        calculationStoryField = findViewById(R.id.text_view_calculation_story_field);
        calculationStoryField.setMovementMethod(new ScrollingMovementMethod());
        Button btnOne = findViewById(R.id.button_one);
        Button btnTwo = findViewById(R.id.button_two);
        Button btnThree = findViewById(R.id.button_three);
        Button btnFour = findViewById(R.id.button_four);
        Button btnFive = findViewById(R.id.button_five);
        Button btnSix = findViewById(R.id.button_six);
        Button btnSeven = findViewById(R.id.button_seven);
        Button btnEight = findViewById(R.id.button_eight);
        Button btnNine = findViewById(R.id.button_nine);
        Button btnZero = findViewById(R.id.button_zero);
        Button btnDot = findViewById(R.id.button_dot);
        Button btnClear = findViewById(R.id.button_clear);
        Button btnDelete = findViewById(R.id.button_delete);
        Button btnAddition = findViewById(R.id.button_addition);
        Button btnSubtraction = findViewById(R.id.button_subtraction);
        Button btnMultiplication = findViewById(R.id.button_multiplication);
        Button btnDivision = findViewById(R.id.button_division);
        Button btnPercent = findViewById(R.id.button_percent);
        Button btnEquals = findViewById(R.id.button_equals);
        String btnNameOne = getResources().getString(R.string.button_label_one);
        String btnNameTwo = getResources().getString(R.string.button_label_two);
        String btnNameThree = getResources().getString(R.string.button_label_three);
        String btnNameFour = getResources().getString(R.string.button_label_four);
        String btnNameFive = getResources().getString(R.string.button_label_five);
        String btnNameSix = getResources().getString(R.string.button_label_six);
        String btnNameSeven = getResources().getString(R.string.button_label_seven);
        String btnNameEight = getResources().getString(R.string.button_label_eight);
        String btnNameNine = getResources().getString(R.string.button_label_nine);
        String btnNameZero = getResources().getString(R.string.button_label_zero);
        String btnNameDot = getResources().getString(R.string.button_label_dot);
        String btnNameAddition = getResources().getString(R.string.button_label_addition);
        String btnNameSubtraction = getResources().getString(R.string.button_label_subtraction);
        String btnNameMultiplication = getResources().getString(R.string.button_label_multiplication);
        String btnNameDivision = getResources().getString(R.string.button_label_division);
        setOnOperandOrOperationButtonClick(btnOne, btnNameOne);
        setOnOperandOrOperationButtonClick(btnTwo, btnNameTwo);
        setOnOperandOrOperationButtonClick(btnThree, btnNameThree);
        setOnOperandOrOperationButtonClick(btnFour, btnNameFour);
        setOnOperandOrOperationButtonClick(btnFive, btnNameFive);
        setOnOperandOrOperationButtonClick(btnSix, btnNameSix);
        setOnOperandOrOperationButtonClick(btnSeven, btnNameSeven);
        setOnOperandOrOperationButtonClick(btnEight, btnNameEight);
        setOnOperandOrOperationButtonClick(btnNine, btnNameNine);
        setOnOperandOrOperationButtonClick(btnZero, btnNameZero);
        setOnOperandOrOperationButtonClick(btnDot, btnNameDot);
        setOnOperandOrOperationButtonClick(btnAddition, btnNameAddition);
        setOnOperandOrOperationButtonClick(btnSubtraction, btnNameSubtraction);
        setOnOperandOrOperationButtonClick(btnMultiplication, btnNameMultiplication);
        setOnOperandOrOperationButtonClick(btnDivision, btnNameDivision);
        setOnDeleteButtonClick(btnDelete);
        setOnClearButtonClick(btnClear);
        setOnPercentButtonClick(btnPercent);
        setOnEqualsButtonClick(btnEquals);
        float textSize = btnOne.getTextSize();
        calculationField.setTextSize(textSize);
        resultField.setTextSize(textSize);
        calculationStoryField.setTextSize(textSize);
    }

    private void setOnDeleteButtonClick(Button btn) {
        btn.setOnClickListener(view -> {
            String expression = calculationField.getText().toString();
            expression = calculator.deleteButton(expression);
            calculationField.setText(expression);
            resultField.setText(calculateResult(expression));
        });
    }

    private void setOnClearButtonClick(Button btn) {
        btn.setOnClickListener(view -> {
            String expression = calculator.clearButton();
            calculationField.setText(expression);
            resultField.setText(expression);
        });
    }

    private void setOnOperandOrOperationButtonClick(Button btn, String btnName) {
        btn.setOnClickListener(view -> {
            String expression = calculationField.getText().toString();
            expression = calculator.operandOrOperationButton(btnName, expression);
            calculationField.setText(expression);
            resultField.setText(calculateResult(expression));
        });
    }

    private void setOnPercentButtonClick(Button btn) {
        btn.setOnClickListener(view -> {
            String expression = calculationField.getText().toString();

            if (expression.isEmpty()) {
                return;
            }

            expression = expressionQualifier(expression);
            expression = calculator.percentButton(expression);
            calculationField.setText(expression);
            resultField.setText(calculateResult(expression));
        });
    }

    private void setOnEqualsButtonClick(Button btn) {
        btn.setOnClickListener(view -> {
            String expression = calculationField.getText().toString();
            expression = expressionQualifier(expression);
            calculationStoryField.append(expression + "\n");
            expression = resultField.getText().toString();
            calculationStoryField.append("=" + expression + "\n");
            calculationField.setText(expression);
        });
    }


    private String calculateResult(String expression) {
        expression = expressionQualifier(expression);
        String result = calculator.equalsButton(expression);
        return resultQualifier(result);
    }


    private String expressionQualifier(String expression) {
        char lastElement = expression.charAt(expression.length() - 1);

        if (!Character.isDigit(lastElement)) {
            expression = calculator.deleteButton(expression);
        }

        return expression;
    }

    private String resultQualifier(String value) {
        Double result;

        try {
            result = Double.parseDouble(value);
        } catch (NumberFormatException exception) {
            return value;
        }

        if (result == Math.floor(result) && !Double.isInfinite(result)) {
            return String.valueOf(result.intValue());
        }

        return String.valueOf(result);
    }
}
