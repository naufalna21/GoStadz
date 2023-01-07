package com.naufal.gostadzfix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartScreen extends AppCompatActivity {
    private Button b_useemail;
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
    public void LoginScreen (View view){
        startActivity(new Intent(this, LoginScreen.class));
    }
}