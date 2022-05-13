package com.example.tic_tac_toe_game;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Arrays;
import java.util.List;

public class GameBoardActivity extends AppCompatActivity {
    private static final List<Integer> TOP_LEFT = Arrays.asList(0, 0);
    private static final List<Integer> TOP = Arrays.asList(1, 0);
    private static final List<Integer> TOP_RIGHT = Arrays.asList(2, 0);
    private static final List<Integer> MIDDLE_LEFT = Arrays.asList(0, 1);
    private static final List<Integer> MIDDLE = Arrays.asList(1, 1);
    private static final List<Integer> MIDDLE_RIGHT = Arrays.asList(2, 1);
    private static final List<Integer> BOTTOM_LEFT = Arrays.asList(0, 2);
    private static final List<Integer> BOTTOM = Arrays.asList(1, 2);
    private static final List<Integer> BOTTOM_RIGHT = Arrays.asList(2, 2);
    private static final String CROSS = "X";
    public static final String CIRCLE = "O";
    private ImageView topLeftImage;
    private ImageView topImage;
    private ImageView topRightImage;
    private ImageView middleLeftImage;
    private ImageView middleImage;
    private ImageView middleRightImage;
    private ImageView bottomLeftImage;
    private ImageView bottomImage;
    private ImageView bottomRightImage;
    private TextView gameScore;
    private String lastTurn = "";
    private int firstPlayerWinRate = 0;
    private int secondPlayerWinRate = 0;
    private final String[][] grid = new String[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);
        changeGridSize();
        topLeftImage = findViewById(R.id.image_top_left);
        topImage = findViewById(R.id.image_top);
        topRightImage = findViewById(R.id.image_top_right);
        middleLeftImage = findViewById(R.id.image_middle_left);
        middleImage = findViewById(R.id.image_middle);
        middleRightImage = findViewById(R.id.image_middle_right);
        bottomLeftImage = findViewById(R.id.image_bottom_left);
        bottomImage = findViewById(R.id.image_bottom);
        bottomRightImage = findViewById(R.id.image_bottom_right);
        gameScore = findViewById(R.id.text_view_game_score);
        Button newGame = findViewById(R.id.button_new_game);
        Button resetGame = findViewById(R.id.button_reset_game);
        topLeftImage.setOnClickListener(view -> makeTurn(topLeftImage, TOP_LEFT));
        topImage.setOnClickListener(view -> makeTurn(topImage, TOP));
        topRightImage.setOnClickListener(view -> makeTurn(topRightImage, TOP_RIGHT));
        middleLeftImage.setOnClickListener(view -> makeTurn(middleLeftImage, MIDDLE_LEFT));
        middleImage.setOnClickListener(view -> makeTurn(middleImage, MIDDLE));
        middleRightImage.setOnClickListener(view -> makeTurn(middleRightImage, MIDDLE_RIGHT));
        bottomLeftImage.setOnClickListener(view -> makeTurn(bottomLeftImage, BOTTOM_LEFT));
        bottomImage.setOnClickListener(view -> makeTurn(bottomImage, BOTTOM));
        bottomRightImage.setOnClickListener(view -> makeTurn(bottomRightImage, BOTTOM_RIGHT));
        newGame.setOnClickListener(view -> newGame());
        resetGame.setOnClickListener(view -> resetGame());
    }

    @SuppressLint("SetTextI18n")
    private void newGame() {
        topLeftImage.setImageResource(android.R.color.transparent);
        topImage.setImageResource(android.R.color.transparent);
        topRightImage.setImageResource(android.R.color.transparent);
        middleLeftImage.setImageResource(android.R.color.transparent);
        middleImage.setImageResource(android.R.color.transparent);
        middleRightImage.setImageResource(android.R.color.transparent);
        bottomLeftImage.setImageResource(android.R.color.transparent);
        bottomImage.setImageResource(android.R.color.transparent);
        bottomRightImage.setImageResource(android.R.color.transparent);
        lastTurn = "";
        gameScore.setText(firstPlayerWinRate + ":" + ++secondPlayerWinRate);
    }

    private void resetGame() {
        firstPlayerWinRate = 0;
        secondPlayerWinRate = -1;
        newGame();
    }

    private String turnOrderQualifier() {
        if (lastTurn.equals("")) {
            fillGrid();
            lastTurn = CROSS;
            return CROSS;
        }

        if (lastTurn.equals(CROSS)) {
            lastTurn = CIRCLE;
            return CIRCLE;
        }

        lastTurn = CROSS;
        return CROSS;
    }

    private void makeTurn(ImageView image, List<Integer> position) {
        String side = turnOrderQualifier();
        int x = position.get(0);
        int y = position.get(1);

        if (!grid[x][y].equals(".")) {
            return;
        }

        grid[x][y] = side;

        switch (side) {
            case ("X"):
                image.setImageResource(R.drawable.cross);
                break;
            case ("O"):
                image.setImageResource(R.drawable.circle);
        }

    }

    private void fillGrid() {
        for (String[] row : grid) {
            Arrays.fill(row, ".");
        }
    }

    private void changeGridSize() {
        ConstraintLayout grid = findViewById(R.id.grid);
        grid.post(() -> {
            ViewGroup.LayoutParams params = grid.getLayoutParams();
            params.height = grid.getWidth();
            grid.setLayoutParams(params);
        });
    }
}