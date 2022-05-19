package com.example.tic_tac_toe_game;

import android.widget.ImageView;

public class Grid {
    private final ImageView[][] grid = new ImageView[3][3];

    public boolean isEmpty() {
        for (ImageView[] row : grid) {
            for (ImageView image : row) {
                try {
                    if (image.getDrawable() != null) {
                        return false;
                    }
                } catch (NullPointerException exception) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isTileEmpty(int x, int y) {
        ImageView image = grid[x][y];
        return image == null || image.getDrawable() == null;
    }

    public void clearGrid() {
        for (ImageView[] row : grid) {
            for (ImageView image : row) {
                try {
                    image.setImageDrawable(null);
                } catch (NullPointerException ignore) {
                }
            }
        }
    }

    public void setImage(int x, int y, ImageView image) {
        grid[x][y] = image;
    }
}
