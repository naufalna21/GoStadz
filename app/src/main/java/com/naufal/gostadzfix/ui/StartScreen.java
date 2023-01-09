package com.naufal.gostadzfix.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.naufal.gostadzfix.R;
import com.naufal.gostadzfix.data.resources.remote.UserRemoteDataSource;
import com.naufal.gostadzfix.data.resources.repository.UserRepository;
import com.naufal.gostadzfix.helper.MoveActivity;

public class StartScreen extends AppCompatActivity {
    private Button b_useemail;
    private UserRemoteDataSource userRemoteDataSource = new UserRemoteDataSource();
    private UserRepository userRepository = new UserRepository(userRemoteDataSource);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);
        b_useemail = findViewById(R.id.useemail);
        b_useemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginScreen(view);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        if (this.userRepository.checkHasUser()) {
            MoveActivity.toHomeScreen(getApplicationContext());
        }

    }
    public void LoginScreen (View view){
        startActivity(new Intent(this, LoginScreen.class));
    }
}