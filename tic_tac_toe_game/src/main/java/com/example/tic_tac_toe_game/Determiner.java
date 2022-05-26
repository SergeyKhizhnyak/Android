package com.example.tic_tac_toe_game;

import android.graphics.Paint;
import android.widget.ImageView;

public class Determiner {
    private final int playerTurn = Paint.UNDERLINE_TEXT_FLAG;
    private final Player playerOne;
    private final Player playerTwo;

    public Determiner(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public Player turnDeterminer() {
        if (playerOne.getTurn() == playerTurn) {
            playerOne.setTurn(0);
            playerTwo.setTurn(playerTurn);
            return playerOne;
        }

        if (playerTwo.getTurn() != playerTurn &&
                playerOne.getTurn() != playerTurn &&
                playerOne.getSide() == R.drawable.cross) {
            playerTwo.setTurn(playerTurn);
            return playerOne;
        }

        playerOne.setTurn(playerTurn);
        playerTwo.setTurn(0);
        return playerTwo;
    }

    public void sideDeterminer() {
        int number = (int) (Math.random() * 2);

        if (number < 1) {
            playerOne.setTurn(playerTurn);
            playerOne.setSide(R.drawable.cross);
            playerTwo.setSide(R.drawable.circle);
            return;
        }

        playerTwo.setTurn(playerTurn);
        playerOne.setSide(R.drawable.circle);
        playerTwo.setSide(R.drawable.cross);
    }

    public boolean winDeterminer(ImageView[][] grid, Player player) {
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

    private boolean rowsForWinCheck(ImageView[][] grid, int side) {
        for (int y = 0; y < grid.length; y++) {
            int counter = 0;

            for (ImageView[] row : grid) {
                Object tag = row[y].getTag();

                if (tag == null) {
                    break;
                }

                if (!tag.equals(side)) {
                    break;
                }

                counter += 1;
            }

            if (counter == 3) {
                return true;
            }
        }

        return false;
    }

    private boolean columnsForWinCheck(ImageView[][] grid, int side) {
        for (ImageView[] row : grid) {
            int counter = 0;

            for (int y = 0; y < grid.length; y++) {
                Object tag = row[y].getTag();

                if (tag == null) {
                    break;
                }

                if (!tag.equals(side)) {
                    break;
                }

                counter += 1;
            }

            if (counter == 3) {
                return true;
            }
        }

        return false;
    }

    private boolean leftDiagonalForWinCheck(ImageView[][] grid, int side) {
        for (int i = 0; i < grid.length; i++) {
            Object tag = grid[i][i].getTag();

            if (tag == null) {
                return false;
            }

            if (!tag.equals(side)) {
                return false;
            }
        }

        return true;
    }

    private boolean rightDiagonalForWinCheck(ImageView[][] grid, int side) {
        for (int x = 0; x < grid.length; x++) {
            Object tag = grid[x][grid.length - 1 - x].getTag();

            if (tag == null) {
                return false;
            }

            if (!tag.equals(side)) {
                return false;
            }
        }

        return true;
    }
}
