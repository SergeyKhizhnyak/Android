package com.example.tic_tac_toe_game;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class GameBoardActivity extends AppCompatActivity {
    private Grid grid;
    private TicTacToeGame game;
    private LinearLayout gameBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);
        Player playerOne = new Player(
                getResources().getString(R.string.player_one),
                findViewById(R.id.text_view_player_one_turn_order),
                findViewById(R.id.text_view_player_one_count));
        Player playerTwo = new Player(
                getResources().getString(R.string.player_two),
                findViewById(R.id.text_view_player_two_turn_order),
                findViewById(R.id.text_view_player_two_count));
        Determiner determiner = new Determiner(playerOne, playerTwo);
        determiner.sideDeterminer();
        grid = new Grid();
        game = new TicTacToeGame(this, determiner, grid, playerOne, playerTwo);
        gameBoard = findViewById(R.id.game_board);
        createGameBoard();
        Button newGame = findViewById(R.id.button_new_game);
        Button resetGame = findViewById(R.id.button_reset_game);
        newGame.setOnClickListener(view -> game.newGame());
        Intent intent = new Intent(this, GameBoardActivity.class);
        resetGame.setOnClickListener(view -> game.resetGame(intent));
    }

    private void createGameBoard() {
        int length = grid.getGrid().length;

        for (int y = 0; y < length; y++) {
            LinearLayout row = new LinearLayout(this);
            row.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    1));
            row.setWeightSum(3);

            for (int x = 0; x < length; x++) {
                ImageView image = new ImageView(this);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        1);
                image.setLayoutParams(params);
                row.addView(image);
                grid.setGridElement(x, y, image);
                game.makeTurn(grid.getGrid(), image);
            }

            gameBoard.addView(row);
        }
    }
}
