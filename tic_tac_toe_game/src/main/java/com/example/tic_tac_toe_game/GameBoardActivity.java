package com.example.tic_tac_toe_game;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class GameBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);
        ConstraintLayout grid = findViewById(R.id.grid);
        grid.post(() -> {
            ViewGroup.LayoutParams params = grid.getLayoutParams();
            params.height = grid.getWidth();
            grid.setLayoutParams(params);
        });
    }
}