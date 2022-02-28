package com.example.constructing_view_layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.permisions.R;

public class RelativeLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);
        Button nextLayout = findViewById(R.id.buttonNextLayout);
        nextLayout.setOnClickListener(view -> {
            Intent intent = new Intent(this, ConstraintLayoutActivity.class);
            startActivity(intent);
        });
    }
}