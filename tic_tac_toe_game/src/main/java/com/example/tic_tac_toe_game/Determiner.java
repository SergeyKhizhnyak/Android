package com.example.tic_tac_toe_game;

public class Determiner {
    private final Player playerOne;
    private final Player playerTwo;

    public Determiner(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void sideDeterminer() {
        if (Math.random() * 2 < 1) {
            playerOne.setTurnTrue();
            playerTwo.setTurnFalse();
            playerOne.setSide(R.drawable.cross);
            playerTwo.setSide(R.drawable.circle);
            return;
        }

        playerOne.setTurnFalse();
        playerTwo.setTurnTrue();
        playerOne.setSide(R.drawable.circle);
        playerTwo.setSide(R.drawable.cross);
    }

    public Player turnDeterminer() {
        if (playerOne.isTurn()) {
            playerOne.setTurnFalse();
            playerTwo.setTurnTrue();
            return playerOne;
        }

        if (!playerOne.isTurn() && !playerTwo.isTurn() && playerOne.getSide() == R.drawable.cross) {
            playerOne.setTurnFalse();
            playerTwo.setTurnTrue();
            return playerOne;
        }

        playerOne.setTurnTrue();
        playerTwo.setTurnFalse();
        return playerTwo;
    }
}
