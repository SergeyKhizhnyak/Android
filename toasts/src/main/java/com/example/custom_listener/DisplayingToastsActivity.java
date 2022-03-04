package com.example.custom_listener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayingToastsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaying_toasts);
        Button defaultToast = findViewById(R.id.buttonDefaultToast);
        defaultToast.setOnClickListener(view -> Toast.makeText(
                this,
                "Default Toast",
                Toast.LENGTH_SHORT)
                .show());

        Button toastWithGravity = findViewById(R.id.buttonToastWithGravity);
        toastWithGravity.setOnClickListener(view -> {
            Toast toast = Toast.makeText(
                    getApplicationContext(),
                    "Toast with gravity",
                    Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        });

        Button customToast = findViewById(R.id.buttonCustomToast);
        customToast.setOnClickListener(view -> {
            String message = "Custom toast";
            displayToast(message);
        });
    }

    private void displayToast(String message) {
        View layout = getLayoutInflater().inflate(R.layout.toast_layout,
                findViewById(R.id.toast_layout_root));
        TextView text = layout.findViewById(R.id.text);
        text.setText(message);
        Toast toast = new Toast(getApplicationContext());
        toast.setView(layout);
        toast.show();
    }
}