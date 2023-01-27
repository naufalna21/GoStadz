package com.naufal.gostadzfix.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.naufal.gostadzfix.R;
import com.naufal.gostadzfix.data.resources.remote.UserRemoteDataSource;
import com.naufal.gostadzfix.data.resources.repository.UserRepository;
import com.naufal.gostadzfix.helper.MoveActivity;

public class HomeScreenJamaah extends AppCompatActivity {
    private UserRemoteDataSource userRemoteDataSource = new UserRemoteDataSource();
    private UserRepository userRepository = new UserRepository(userRemoteDataSource);

    private LinearLayout l_video,l_ustadz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen_jamaah);
        l_video = findViewById(R.id.VideodanCeramah);
        l_ustadz = findViewById(R.id.orderustadz);
        l_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MoveActivity.toVideoAndCeramahScreen(getApplicationContext());
            }
        });
        l_ustadz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MoveActivity.toListUstadz(getApplicationContext());
            }
        });
    }
}