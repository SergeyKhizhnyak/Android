package com.example.tic_tac_toe_game;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.Toast;

public class TicTacToeGame {
    private final Context context;
    private final Determiner determiner;
    private final Grid grid;
    private final Player playerOne;
    private final Player playerTwo;

    public TicTacToeGame(
            Context context,
            Determiner determiner,
            Grid grid,
            Player playerOne,
            Player playerTwo) {
        this.context = context;
        this.determiner = determiner;
        this.grid = grid;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void makeTurn(ImageView[][] imageViews, ImageView image) {
        image.setOnClickListener(view -> {
            if (image.getTag() != null) {
                return;
            }

            Player player = determiner.turnDeterminer();
            player.makeTurn(image);

            if (isWin(imageViews, player)) {
                winCase(player);
            }
        });
    }

    public void newGame() {
        if (grid.isGridEmpty()) {
            return;
        }

        if (playerOne.isTurn()) {
            playerTwo.setCount(playerTwo.getCount() + 1);
            playerOne.setTurnFalse();
        } else {
            playerOne.setCount(playerOne.getCount() + 1);
            playerTwo.setTurnFalse();
        }

        determiner.sideDeterminer();
        grid.clearGrid();
    }

    public void resetGame(Intent intent) {
        if (grid.isGridEmpty()) {
            if (playerOne.getCount() == 0 && playerTwo.getCount() == 0) {
                return;
            }
        }

        ((Activity) context).finish();
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(0, 0);
    }

    private boolean isWin(ImageView[][] grid, Player player) {
        int side = player.getSide();

        if (rowsForWinCheck(grid, side)) {
            return true;
        }

        if (columnsForWinCheck(grid, side)) {
            return true;
        }

        if (leftDiagonalForWinCheck(grid, side)) {
            return true;
        }

        return rightDiagonalForWinCheck(grid, side);
    }

    public void winCase(Player player) {
        Toast.makeText(context, player.getName() + " wins", Toast.LENGTH_SHORT).show();
        player.setCount(player.getCount() + 1);
        determiner.sideDeterminer();
        new Handler().postDelayed(grid::clearGrid, 2000);
    }

    private boolean rowsForWinCheck(ImageView[][] grid, int side) {
        for (int x = 0; x < grid.length; x++) {
            int counter = 0;

            for (ImageView[] row : grid) {
                try {
                    if (row[x].getTag().equals(side)) {
                        counter += 1;
                    }
                } catch (NullPointerException exception) {
                    break;
                }
            }

            if (counter == grid.length) {
                return true;
            }
        }

        return false;
    }

    private boolean columnsForWinCheck(ImageView[][] grid, int side) {
        for (ImageView[] column : grid) {
            int counter = 0;

            for (int y = 0; y < grid.length; y++) {
                try {
                    if (column[y].getTag().equals(side)) {
                        counter += 1;
                    }
                } catch (NullPointerException exception) {
                    break;
                }
            }

            if (counter == grid.length) {
                return true;
            }
        }

        return false;
    }

    private boolean leftDiagonalForWinCheck(ImageView[][] grid, int side) {
        for (int i = 0; i < grid.length; i++) {
            try {
                if (!grid[i][i].getTag().equals(side)) {
                    return false;
                }
            } catch (NullPointerException exception) {
                return false;
            }
        }

        return true;
    }

    private boolean rightDiagonalForWinCheck(ImageView[][] grid, int side) {
        for (int x = 0; x < grid.length; x++) {
            try {
                if (!grid[x][grid.length - 1 - x].getTag().equals(side)) {
                    return false;
                }
            } catch (NullPointerException exception) {
                return false;
            }
        }

        return true;
    }
}
