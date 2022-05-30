package com.example.tic_tac_toe_game;

import android.graphics.Paint;
import android.widget.ImageView;
import android.widget.TextView;

public class Player {
    private final String name;
    private final TextView turn;
    private final TextView count;

    private int side;

    public Player(String name, TextView turn, TextView count) {
        this.name = name;
        this.turn = turn;
        this.count = count;
    }

    public void makeTurn(ImageView image) {
        image.setImageResource(side);
        image.setTag(side);
    }

    public boolean isTurn() {
        return turn.getPaintFlags() == Paint.UNDERLINE_TEXT_FLAG;
    }

    public void setTurnTrue() {
        turn.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
    }

    public void setTurnFalse() {
        turn.setPaintFlags(0);
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return Integer.parseInt((String) count.getText());
    }

    public int getSide() {
        return side;
    }

    public void setCount(int count) {
        this.count.setText(String.valueOf(count));
    }

    public void setSide(int side) {
        this.side = side;
    }
}
