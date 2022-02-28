package com.example.work_with_image_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class WorkWithImageViewActivity extends AppCompatActivity {
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_with_image_view);
        image = findViewById(R.id.imageView);
        Button center = findViewById(R.id.buttonCenter);
        click(center, ImageView.ScaleType.CENTER);
        Button centerCrop = findViewById(R.id.buttonCenterCrop);
        click(centerCrop, ImageView.ScaleType.CENTER_CROP);
        Button centerInside = findViewById(R.id.buttonCenterInside);
        click(centerInside, ImageView.ScaleType.CENTER_INSIDE);
        Button matrix = findViewById(R.id.buttonMatrix);
        click(matrix, ImageView.ScaleType.MATRIX);
        Button fitCenter = findViewById(R.id.buttonFitCenter);
        click(fitCenter, ImageView.ScaleType.FIT_CENTER);
        Button fitEnd = findViewById(R.id.buttonFitEnd);
        click(fitEnd, ImageView.ScaleType.FIT_END);
        Button fitStart = findViewById(R.id.buttonFitStart);
        click(fitStart, ImageView.ScaleType.FIT_START);
        Button fitXY = findViewById(R.id.buttonFitXY);
        click(fitXY, ImageView.ScaleType.FIT_XY);
    }

    private void click(Button btn, ImageView.ScaleType scaleType) {
        btn.setOnClickListener(view -> image.setScaleType(scaleType));
    }
}