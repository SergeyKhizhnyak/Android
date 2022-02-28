package com.example.work_with_scroll_view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class WorkWithScrollViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_with_scroll_view);
        Button nextLayout = findViewById(R.id.buttonNextLayout);
        nextLayout.setOnClickListener(view -> {
            Intent intent = new Intent(this, ScrollableTextViewActivity.class);
            startActivity(intent);
        });
    }
}