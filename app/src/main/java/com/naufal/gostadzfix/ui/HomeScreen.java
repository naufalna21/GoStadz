package com.naufal.gostadzfix.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.naufal.gostadzfix.R;
import com.naufal.gostadzfix.data.resources.remote.UserRemoteDataSource;
import com.naufal.gostadzfix.data.resources.repository.UserRepository;
import com.naufal.gostadzfix.helper.MoveActivity;

public class HomeScreen extends AppCompatActivity {
    private UserRemoteDataSource userRemoteDataSource = new UserRemoteDataSource();
    private UserRepository userRepository = new UserRepository(userRemoteDataSource);

    private LinearLayout l_jamaah;
    private ImageButton ib_setting;
    private LinearLayout l_ustadz;
    private Button b_logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        l_jamaah = findViewById(R.id.homescreenjamaah);
        l_ustadz = findViewById(R.id.homescreenustadz);
        ib_setting = findViewById(R.id.setting);
        b_logout=findViewById(R.id.logout);

        ib_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        l_jamaah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MoveActivity.toHomeScreenJamaah(getApplicationContext());
            }
        });
        l_ustadz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MoveActivity.toHomeScreenUstadz(getApplicationContext());
            }
        });
        b_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                MoveActivity.toLoginScreen(getApplicationContext());
                finish();
            }
        });
        ib_setting.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                MoveActivity.toBiodataScreen(getApplicationContext());
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