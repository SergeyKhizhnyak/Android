package com.example.tic_tac_toe_game;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameBoardActivity extends AppCompatActivity {
    private final Grid grid = new Grid();

    private TicTacToeGame ticTacToeGame;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);
        intent = new Intent(this, GameBoardActivity.class);
        Player playerOne = new Player(
                findViewById(R.id.text_view_player_one),
                getResources().getString(R.string.player_one));
        Player playerTwo = new Player(
                findViewById(R.id.text_view_player_two),
                getResources().getString(R.string.player_two));
        Determiner determiner = new Determiner(playerOne, playerTwo);
        determiner.sideDeterminer();
        TextView gameScore = findViewById(R.id.text_view_game_score);
        grid.makeGrid(
                findViewById(R.id.game_board),
                this,
                playerOne,
                playerTwo,
                determiner,
                gameScore);
        ticTacToeGame = new TicTacToeGame(this, determiner, playerOne, playerTwo, gameScore);
        Button newGame = findViewById(R.id.button_new_game);
        Button resetGame = findViewById(R.id.button_reset_game);
        newGame.setOnClickListener(view -> ticTacToeGame.newGame(grid));
        resetGame.setOnClickListener(view -> ticTacToeGame.resetGame(intent));
    }
}
