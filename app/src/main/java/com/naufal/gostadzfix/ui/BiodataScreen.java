package com.naufal.gostadzfix.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.naufal.gostadzfix.R;
import com.naufal.gostadzfix.data.model.User;
import com.naufal.gostadzfix.data.resources.interfaces.UserDataSource;
import com.naufal.gostadzfix.data.resources.remote.UserRemoteDataSource;
import com.naufal.gostadzfix.data.resources.repository.UserRepository;
import com.naufal.gostadzfix.helper.MoveActivity;

public class BiodataScreen extends AppCompatActivity {
    private UserRemoteDataSource userRemoteDataSource = new UserRemoteDataSource();
    private UserRepository userRepository = new UserRepository(userRemoteDataSource);
    private EditText et_firstname,et_lastname, et_tanggallahir, et_nophone,et_provinsi, et_kabupatenkota, et_kecamatan,et_email;
    private Button b_simpan;
    private ImageButton b_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.biodata_screen);
        et_firstname = findViewById(R.id.firstname);
        et_lastname = findViewById(R.id.lastname);
        et_tanggallahir = findViewById(R.id.tanggallahir);
        et_nophone = findViewById(R.id.nohp);
//        et_email = findViewById(R.id.editemail)
        et_kecamatan = findViewById(R.id.kecamatan);
        et_provinsi = findViewById(R.id.provinsi);
        et_kabupatenkota = findViewById(R.id.kabupatenkota);
        b_simpan = findViewById(R.id.buttonsimpanprofil);
        b_back = findViewById(R.id.back);


        userRepository.getUserbyLogin(new UserDataSource.GetUserCallback() {
            @Override
            public void success(User user) {
                et_firstname.setText(user.getFirstname());

                et_lastname.setText(user.getLastname());
                et_tanggallahir.setText(user.getTanggallahir());
                et_nophone.setText(user.getNophone());
                et_provinsi.setText(user.getProvinsi());
                et_kecamatan.setText(user.getKecamatan());
                et_kabupatenkota.setText(user.getKabupaten_kota());
            }

            @Override
            public void error(Throwable err) {

            }
        });



        b_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User(et_firstname.getText().toString(),et_lastname.getText().toString(),et_tanggallahir.getText().toString(),et_provinsi.getText().toString(),et_kabupatenkota.getText().toString(),et_kecamatan.getText().toString(), et_nophone.getText().toString());
                userRepository.editDataUsers(user, new UserDataSource.UserCallback() {
                    @Override
                    public void success(boolean success) {
                        Toast.makeText(getApplicationContext(), "Berhasil Merubah Data ", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void error(Throwable err) {

                    }
                });
            }
        });

        b_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MoveActivity.toHomeScreen(getApplicationContext());
            }
        });

    }
}