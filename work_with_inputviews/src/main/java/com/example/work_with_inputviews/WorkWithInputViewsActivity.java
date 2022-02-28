package com.example.work_with_inputviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class WorkWithInputViewsActivity extends AppCompatActivity {
    private static final String FIRST_ITEM = "First item is selected";
    private static final String SECOND_ITEM = "Second item is selected";
    private static final String THIRD_ITEM = "Third item is selected";
    private static final String FOURTH_ITEM = "Fourth item is selected";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_with_input_views);
        CompoundButton.OnCheckedChangeListener check = (view, isChecked) -> {
            Context context = WorkWithInputViewsActivity.this;
            switch (view.getId()) {
                case (R.id.checkBoxFirstItem):
                    Toast.makeText(
                            context,
                            FIRST_ITEM,
                            Toast.LENGTH_SHORT)
                            .show();
                    break;
                case (R.id.checkboxSecondItem):
                    Toast.makeText(
                            context,
                            SECOND_ITEM,
                            Toast.LENGTH_SHORT)
                            .show();
                    break;
                case (R.id.checkboxThirdItem):
                    Toast.makeText(
                            context,
                            THIRD_ITEM,
                            Toast.LENGTH_SHORT)
                            .show();
                    break;
                case (R.id.checkboxFourthItem):
                    Toast.makeText(
                            context,
                            FOURTH_ITEM,
                            Toast.LENGTH_SHORT)
                            .show();
            }
        };

        CheckBox checkBoxFirstItem = findViewById(R.id.checkBoxFirstItem);
        checkBoxFirstItem.setOnCheckedChangeListener(check);
        CheckBox checkBoxSecondItem = findViewById(R.id.checkboxSecondItem);
        checkBoxSecondItem.setOnCheckedChangeListener(check);
        CheckBox checkBoxThirdItem = findViewById(R.id.checkboxThirdItem);
        checkBoxThirdItem.setOnCheckedChangeListener(check);
        CheckBox checkBoxFourthItem = findViewById(R.id.checkboxFourthItem);
        checkBoxFourthItem.setOnCheckedChangeListener(check);
        RadioButton radioButtonFirstItem = findViewById(R.id.radioButtonFirstItem);
        isRadioButtonActive(radioButtonFirstItem, FIRST_ITEM);
        RadioButton radioButtonSecondItem = findViewById(R.id.radioButtonSecondItem);
        isRadioButtonActive(radioButtonSecondItem, SECOND_ITEM);
        Spinner spinner = findViewById(R.id.spinnerPlanets);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(
                    AdapterView<?> parent,
                    View selectedItem,
                    int itemPosition,
                    long itemID) {
                String[] numbers = getResources().getStringArray(R.array.planets_array);
                Toast.makeText(
                        WorkWithInputViewsActivity.this,
                        numbers[itemPosition] + " is selected",
                        Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        NumberPicker numberPicker = findViewById(R.id.numberPicker);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(10);
        numberPicker.setWrapSelectorWheel(true);
        numberPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        numberPicker.setOnValueChangedListener((numberPicker1, oldVal, newVal) ->
                Toast.makeText(
                this,
                newVal + " is selected",
                Toast.LENGTH_SHORT)
                .show());
    }

    private void isRadioButtonActive(CompoundButton compoundButton, String message) {
        compoundButton.setOnCheckedChangeListener((button, isChecked) -> {
            if (isChecked) {
                Toast.makeText(
                        WorkWithInputViewsActivity.this,
                        message,
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}