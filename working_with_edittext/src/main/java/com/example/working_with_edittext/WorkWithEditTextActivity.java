package com.example.working_with_edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WorkWithEditTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_with_edit_text);
        Button readText = findViewById(R.id.buttonReadPhoneNumber);
        readText.setOnClickListener(view -> {
            EditText contactPhone = findViewById(R.id.editTextContactPhoneNumber);
            String phoneNumber = contactPhone.getText().toString();
            TextView pn = findViewById(R.id.textViewContactPhoneNumber);
            pn.setText(phoneNumber);
        });
    }
}