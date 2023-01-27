package com.naufal.gostadzfix.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.naufal.gostadzfix.R;
import com.naufal.gostadzfix.data.resources.interfaces.UserDataSource;
import com.naufal.gostadzfix.data.resources.remote.UserRemoteDataSource;
import com.naufal.gostadzfix.data.resources.repository.UserRepository;
import com.naufal.gostadzfix.helper.MoveActivity;

public class LoginScreen extends AppCompatActivity {
    private TextView t_registrasi;
    private EditText e_email, e_password;
    private Button b_login;
    private UserRemoteDataSource userRemoteDataSource = new UserRemoteDataSource();
    private UserRepository userRepository = new UserRepository(userRemoteDataSource);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        e_email = findViewById(R.id.editemail);
        e_password = findViewById(R.id.editpassword);
        t_registrasi = findViewById(R.id.createaccount);
        b_login = findViewById(R.id.buttonlogin);
        b_login.setOnClickListener(v -> {
            if (e_email.getText().length() > 0 && e_password.getText().length() > 0) {
                login(e_email.getText().toString(), e_password.getText().toString());
            } else {
                Toast.makeText(getApplicationContext(),"Silakan Masukkkan Email dan Password Anda dengan Benar",Toast.LENGTH_SHORT).show();
            }
        });
        t_registrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MoveActivity.toRegistrasiScreen(getApplicationContext());
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

    private void login(String email, String password) {
        this.userRepository.login(email, password, new UserDataSource.UserCallback() {
            @Override
            public void success(boolean success) {
                MoveActivity.toHomeScreen(getApplicationContext());
            }
            @Override
            public void error(Throwable err) {
                Toast.makeText(getApplicationContext(), err.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}