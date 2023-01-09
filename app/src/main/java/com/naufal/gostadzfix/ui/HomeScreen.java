package com.naufal.gostadzfix.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.naufal.gostadzfix.R;
import com.naufal.gostadzfix.data.resources.remote.UserRemoteDataSource;
import com.naufal.gostadzfix.data.resources.repository.UserRepository;
import com.naufal.gostadzfix.helper.MoveActivity;

public class HomeScreen extends AppCompatActivity {
    private UserRemoteDataSource userRemoteDataSource = new UserRemoteDataSource();
    private UserRepository userRepository = new UserRepository(userRemoteDataSource);

    private LinearLayout l_jamaah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        l_jamaah = findViewById(R.id.homescreenjamaah);

        l_jamaah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MoveActivity.toHomeScreenJamaah(getApplicationContext());
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        if (!this.userRepository.checkHasUser()) {

        }
    }

}