package com.naufal.gostadzfix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoginScreen extends AppCompatActivity {
    private TextView t_registrasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        t_registrasi = findViewById(R.id.createaccount);
        t_registrasi.setOnClickListener(this::RegistrasiScreen);
    }

    public void RegistrasiScreen(View view) {
        startActivity(new Intent(this, RegistrasiScreen.class));
    }
}