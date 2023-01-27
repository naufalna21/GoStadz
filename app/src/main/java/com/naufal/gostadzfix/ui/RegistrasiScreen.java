package com.naufal.gostadzfix.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.naufal.gostadzfix.R;
import com.naufal.gostadzfix.data.resources.interfaces.UserDataSource;
import com.naufal.gostadzfix.data.resources.remote.UserRemoteDataSource;
import com.naufal.gostadzfix.data.resources.repository.UserRepository;
import com.naufal.gostadzfix.helper.MoveActivity;

public class RegistrasiScreen extends AppCompatActivity {

    private UserRemoteDataSource userRemoteDataSource = new UserRemoteDataSource();
    private UserRepository userRepository = new UserRepository(userRemoteDataSource);
    private EditText e_firstname, e_lastname, e_email, e_tanggallahir, e_password, e_nophone;
    private Spinner s_provinsi, s_kabupaten, s_kecamatan;
    private Button b_signup;
    private TextView t_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrasi_screen);

        e_firstname = findViewById(R.id.editfirstname);
        e_lastname = findViewById(R.id.editlastname);
        e_email = findViewById(R.id.editemail);
        e_tanggallahir = findViewById(R.id.edittanggallahir);
        e_password = findViewById(R.id.editpassword);
        e_nophone = findViewById(R.id.nophone);

        b_signup = findViewById(R.id.buttonsignup);

        t_login = findViewById(R.id.loginaccount);

        s_provinsi = findViewById(R.id.spinner_provinsi);
        s_kabupaten = findViewById(R.id.spinner_kabupaten);
        s_kecamatan = findViewById(R.id.spinner_kecamatan);


        s_provinsi.setAdapter(createAdapter(R.array.Provinsi));
        s_kabupaten.setAdapter(createAdapter(R.array.Kabupaten_Kota));
        s_kecamatan.setAdapter(createAdapter(R.array.Kecamatan));


        t_login.setOnClickListener(view -> {
            startActivity(new Intent(this, LoginScreen.class));
        });
        b_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean validation = e_firstname.getText().length() > 0 && e_lastname.getText().length() > 0 && e_email.getText().length() > 0 && s_provinsi.getSelectedItem().toString().length() > 0 && s_kabupaten.getSelectedItem().toString().length() > 0 && s_kecamatan.getSelectedItem().toString().length() > 0 && e_tanggallahir.getText().length() > 0 && e_nophone.getText().length() > 0 && e_password.getText().length() > 0;
                if (validation) {
                    signup(e_firstname.getText().toString(), e_lastname.getText().toString(), e_email.getText().toString(), s_provinsi.getSelectedItem().toString(), s_kabupaten.getSelectedItem().toString(), s_kecamatan.getSelectedItem().toString(), e_tanggallahir.getText().toString(), e_nophone.getText().toString(), e_password.getText().toString());
                } else {
                    Toast.makeText(getApplicationContext(), "Silakan isi semua dengan data", Toast.LENGTH_SHORT).show();
                }
            }
        });
//        b_signup.setOnClickListener(view -> {
//            if(e_firstname.getText().length()>0 && e_lastname.getText().length()>0 && e_email.getText().length()>0 &&  s_provinsi.getSelectedItem().toString().length()>0 &&  s_kabupaten.getSelectedItem().toString().length()>0 && s_kecamatan.getSelectedItem().toString().length()>0 && e_tanggallahir.getText().length()>0 && e_nophone.getText().length()>0  && e_password.getText().length()>0){
//                signup(e_firstname.getText().toString(), e_lastname.getText().toString(), e_email.getText().toString(),s_provinsi.getSelectedItem().toString(),s_kabupaten.getSelectedItem().toString(),s_kecamatan.getSelectedItem().toString(), e_tanggallahir.getText().toString(),e_nophone.getText().toString(), e_password.getText().toString());
//            }else{
//                Toast.makeText(getApplicationContext(), "Silakan isi semua dengan data",Toast.LENGTH_SHORT);
//            }
//        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (this.userRepository.checkHasUser()) {
            MoveActivity.toHomeScreen(getApplicationContext());
        }

    }

    public ArrayAdapter<CharSequence> createAdapter(int resource_id) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, resource_id, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
    }

    private void signup(String firstname, String lastname, String email, String provinsi, String kabupaten_kota, String kecamatan, String tanggallahir, String nophone, String password) {
        this.userRepository.signup(firstname, lastname, email, provinsi, kabupaten_kota, kecamatan, tanggallahir, nophone, password, new UserDataSource.UserCallback() {
            @Override
            public void success(boolean success) {
                MoveActivity.toLoginScreen(getApplicationContext());
            }

            @Override
            public void error(Throwable err) {
                Toast.makeText(getApplicationContext(), err.getMessage(), Toast.LENGTH_SHORT);
            }
        });
    }
}