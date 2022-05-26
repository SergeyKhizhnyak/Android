package com.example.tic_tac_toe_game;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.widget.TextView;
import android.widget.Toast;

public class TicTacToeGame {
    private final static int PLAYER_TURN = Paint.UNDERLINE_TEXT_FLAG;
    private final Context context;
    private final Determiner determiner;
    private final Player playerOne;
    private final Player playerTwo;
    private final TextView gameScore;

    public TicTacToeGame(
            Context context,
            Determiner determiner,
            Player playerOne,
            Player playerTwo,
            TextView gameScore) {
        this.context = context;
        this.determiner = determiner;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.gameScore = gameScore;
    }

    public void newGame(Grid grid) {
        if (grid.isGridEmpty()) {
            return;
        }

        grid.clearGrid();

        if (playerOne.getTurn() == PLAYER_TURN) {
            playerOne.setTurn(0);
            playerTwo.setCount(playerTwo.getCount() + 1);
        } else {
            playerTwo.setTurn(0);
            playerOne.setCount(playerOne.getCount() + 1);
        }

        determiner.sideDeterminer();
        refreshScore();
    }

    public void resetGame(Intent intent) {
        ((Activity) context).finish();
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(0, 0);
    }

    public void inWinCase(Player player) {
        player.setCount(player.getCount() + 1);
        Toast.makeText(context, player.getName() + " wins", Toast.LENGTH_SHORT).show();
        refreshScore();
        determiner.sideDeterminer();
    }

    @SuppressLint("SetTextI18n")
    private void refreshScore() {
        gameScore.setText(playerOne.getCount() + ":" + playerTwo.getCount());
    }
}
