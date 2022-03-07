package com.example.snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class SnackbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);
        View.OnClickListener myOnClickListener = view -> Toast.makeText(
                SnackbarActivity.this,
                "Snackbar works correctly",
                Toast.LENGTH_SHORT).show();

        LinearLayout linearLayout = findViewById(R.id.id);
        Button showSnackbar = findViewById(R.id.button);
        showSnackbar.setOnClickListener(view -> Snackbar
                .make(linearLayout, R.string.snackbar_text, Snackbar.LENGTH_SHORT)
                .setAction(R.string.snackbar_action, myOnClickListener)
                .show());
    }


}