package com.example.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorMainActivity extends AppCompatActivity {
    TextView calculationField;
    TextView resultField;
    TextView calculationStoryField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_main);
        calculationField = findViewById(R.id.text_view_calculation_field);
        resultField = findViewById(R.id.text_view_result_field);

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
        Button btnClear = findViewById(R.id.button_clear);
        Button btnDelete = findViewById(R.id.button_delete);
        Button btnPlus = findViewById(R.id.button_plus);
        Button btnMinus = findViewById(R.id.button_minus);

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
        String btnNamePlus = getResources().getString(R.string.button_label_plus);
        String btnNameMinus = getResources().getString(R.string.button_label_minus);

        onNumberButtonClick(btnOne, btnNameOne);
        onNumberButtonClick(btnTwo, btnNameTwo);
        onNumberButtonClick(btnThree, btnNameThree);
        onNumberButtonClick(btnFour, btnNameFour);
        onNumberButtonClick(btnFive, btnNameFive);
        onNumberButtonClick(btnSix, btnNameSix);
        onNumberButtonClick(btnSeven, btnNameSeven);
        onNumberButtonClick(btnEight, btnNameEight);
        onNumberButtonClick(btnNine, btnNameNine);
        onNumberButtonClick(btnZero, btnNameZero);
        onArithmeticButtonClick(btnPlus, btnNamePlus);
        onArithmeticButtonClick(btnMinus, btnNameMinus);

        btnClear.setOnClickListener(view -> clearButton());
        btnDelete.setOnClickListener(view -> deleteButton());
    }

    private void onNumberButtonClick(Button btn, String btnName) {
        btn.setOnClickListener(view -> {
            String calculation = calculationField.getText().toString();
            if (calculation.isEmpty() && btnName.equals("0")) {
                return;
            }

            calculation = calculation.concat(btnName);
            calculationField.setText(calculation);
            resultField.setText("=" + calculation);
        });
    }

    private void onArithmeticButtonClick(Button btn, String btnName) {
        btn.setOnClickListener(view -> {
            String calculation = calculationField.getText().toString();
            if (calculation.isEmpty()) {
                if (btnName.equals("+")) {
                    calculationField.setHint("0+");
                    return;
                }

                if (btnName.equals("-")) {
                    calculationField.setHint("0-");
                    return;
                }
            }

            char lastElement = calculation.charAt(calculation.length() -1);
            switch (lastElement) {
                case ('+'):

            }
            calculation = calculation.concat(btnName);
            calculationField.setText(calculation);
        });
    }

    private void clearButton() {
        calculationField.setText("");
        resultField.setText("");
    }

    private void deleteButton() {
        String calculation = calculationField.getText().toString();
        if (calculation.length() == 0) {
            return;
        }

        calculation = calculation.substring(0, calculation.length() - 1);
        calculationField.setText(calculation);
        resultField.setText("=" + calculation);
    }
}