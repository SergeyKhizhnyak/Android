package com.example.tic_tac_toe_game;

import android.widget.ImageView;

public class Grid {
    private final ImageView[][] grid = new ImageView[3][3];

    public boolean isGridEmpty() {
        for (int x = 0; x < grid.length; x++) {
            for (ImageView[] row : grid) {
                if (row[x].getDrawable() != null) {
                    return false;
                }
            }
        }

        return true;
    }

    public void clearGrid() {
        for (int x = 0; x < grid.length; x++) {
            for (ImageView[] row : grid) {
                row[x].setImageDrawable(null);
                row[x].setTag(null);
            }
        }
    }

    public ImageView[][] getGrid() {
        return grid;
    }

    public void setGridElement(int x, int y, ImageView image) {
        grid[x][y] = image;
    }
}
