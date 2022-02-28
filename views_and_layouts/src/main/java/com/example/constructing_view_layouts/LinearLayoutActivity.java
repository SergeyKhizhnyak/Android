package com.example.constructing_view_layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.permisions.R;

public class LinearLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layot);
        Button nextLayout = findViewById(R.id.buttonNextLayout);
        nextLayout.setOnClickListener(view -> {
            Intent intent = new Intent(this, RelativeLayoutActivity.class);
            startActivity(intent);
        });
    }
}