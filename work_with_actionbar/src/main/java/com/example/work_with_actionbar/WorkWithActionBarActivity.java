package com.example.work_with_actionbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class WorkWithActionBarActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_with_actionbar);
        Button changeTitle = findViewById(R.id.buttonChangeTitle);
        changeTitle.setOnClickListener(view -> {
            ActionBar actionBar = getSupportActionBar();
            assert actionBar != null;
            actionBar.setTitle("New Title");

        });

        Button hideTittle = findViewById(R.id.buttonHideTittle);
        hideTittle.setOnClickListener(view -> {
            ActionBar actionBar = getSupportActionBar();
            assert actionBar != null;
            if (actionBar.isShowing()) {
                actionBar.hide();
                return;
            }

            actionBar.show();
        });

        Button getTitle = findViewById(R.id.buttonGetTittle);
        getTitle.setOnClickListener(view -> {
            ActionBar actionBar = getSupportActionBar();
            assert actionBar != null;
            String title = Objects.requireNonNull(actionBar.getTitle()).toString();
            TextView textView = findViewById(R.id.title);
            textView.setText(title);
        });

        Button addImage = findViewById(R.id.buttonAddImage);
        addImage.setOnClickListener(view -> {
            ActionBar actionBar = getSupportActionBar();
            assert actionBar != null;
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setLogo(R.drawable.android_image);
            actionBar.setDisplayUseLogoEnabled(true);
        });
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.arrowForward:
                Toast.makeText(
                        this,
                        "Arrow forward is selected",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.arrowBack:
                Toast.makeText(
                        this,
                        "Arrow back is selected",
                        Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}