package com.example.tic_tac_toe_game;

import android.widget.ImageView;
import android.widget.TextView;

public class Player {
    private final TextView turnOrder;

    private final String name;
    private int count;
    private int side;

    public Player(TextView turnOrder, String name) {
        this.turnOrder = turnOrder;
        this.name = name;
    }

    public void makeTurn(ImageView image) {
        image.setImageResource(side);
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public int getTurn() {
        return turnOrder.getPaintFlags();
    }

    public int getSide() {
        return side;
    }


    public void setCount(int count) {
        this.count = count;
    }

    public void setTurn(int turn) {
        turnOrder.setPaintFlags(turn);
    }

    public void setSide(int side) {
        this.side = side;
    }
}
