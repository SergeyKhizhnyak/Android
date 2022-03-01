package com.example.basic_event_listeners;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BasicEventListenersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_event_listeners);
        TextView textView = findViewById(R.id.textView);
        textView.setOnLongClickListener(view -> {
            Toast.makeText(
                    this,
                    "Implement onLongClick event",
                    Toast.LENGTH_SHORT)
                    .show();
            return true;
        });

        Button btn = findViewById(R.id.button);
        btn.setOnLongClickListener(view -> {
            Toast.makeText(
                    this,
                    "Implement onLongClick event",
                    Toast.LENGTH_SHORT)
                    .show();
            return true;
        });

        EditText editText = findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence charSequence,
                    int start,
                    int before,
                    int count) {

            }

            @Override
            public void onTextChanged(
                    CharSequence charSequence,
                    int start,
                    int count,
                    int after) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Toast.makeText(
                        BasicEventListenersActivity.this,
                        "Implement addTextChangeListener",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

        editText.setOnEditorActionListener((textView1, actionId, keyEvent) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                Toast.makeText(
                        BasicEventListenersActivity.this,
                        "Implement setOnEditorActionListener",
                        Toast.LENGTH_SHORT)
                        .show();
                return true;
            }

            return false;
        });
    }

    public void sendMessageOnClick(View view) {
        Toast.makeText(
                this,
                "Implement onClick event using XML",
                Toast.LENGTH_SHORT)
                .show();
    }
}