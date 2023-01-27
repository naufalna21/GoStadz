package com.naufal.gostadzfix.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.naufal.gostadzfix.R;
import com.naufal.gostadzfix.helper.MoveActivity;

public class VideoScreen extends AppCompatActivity {
    private LinearLayout V1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_screen);
        V1 = findViewById(R.id.Lv1);
        V1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MoveActivity.toPlayVideoScreen(getApplicationContext());
            }
        });
    };
}