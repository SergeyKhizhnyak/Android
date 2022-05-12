package com.example.tic_tac_toe_game;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button onePlayer = findViewById(R.id.button_one_player);
        onePlayer.setOnClickListener(view -> {
            Intent intent = new Intent(this, GameBoardActivity.class);
            startActivity(intent);
        });
    }
}