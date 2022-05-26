package com.example.tic_tac_toe_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_menu);
        Button twoPlayers = findViewById(R.id.button_two_players);
        twoPlayers.setOnClickListener(view -> {
            Intent intent = new Intent(this, GameBoardActivity.class);
            startActivity(intent);
        });
    }
}