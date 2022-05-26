package com.example.tic_tac_toe_game;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Grid {
    private final ImageView[][] grid = new ImageView[3][3];

    public void makeGrid(
            LinearLayout linearLayout,
            Context context,
            Player playerOne,
            Player playerTwo,
            Determiner determiner,
            TextView gameScore) {
        for (int y = 0; y < 3; y++) {
            LinearLayout row = new LinearLayout(context);
            row.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    1));
            row.setWeightSum(3);

            for (int x = 0; x < 3; x++) {
                ImageView image = new ImageView(context);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        1);
                layoutParams.setMargins(20, 20, 20, 20);
                grid[x][y] = image;
                row.addView(image, layoutParams);
                image.setOnClickListener(view -> {
                    if (image.getDrawable() != null) {
                        return;
                    }

                    Player player = determiner.turnDeterminer();
                    image.setTag(player.getSide());
                    player.makeTurn(image);

                    if (determiner.winDeterminer(grid, player)) {
                        TicTacToeGame ticTacToeGame = new TicTacToeGame(context, determiner, playerOne, playerTwo, gameScore);
                        ticTacToeGame.inWinCase(player);
                        clearGrid();
                    }
                });
            }

            linearLayout.addView(row);
        }
    }

    public boolean isGridEmpty() {
        for (ImageView[] row : grid) {
            for (ImageView image : row) {
                if (image.getDrawable() != null) {
                    return false;
                }
            }
        }

        return true;
    }

    public void clearGrid() {
        for (ImageView[] row : grid) {
            for (ImageView image : row) {
                image.setImageDrawable(null);
                image.setTag(null);
            }
        }
    }
}
