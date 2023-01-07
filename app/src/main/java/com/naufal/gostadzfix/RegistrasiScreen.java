package com.naufal.gostadzfix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class RegistrasiScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrasi_screen);

        Spinner spinner = (Spinner) findViewById(R.id.provinsi);
        Spinner spinner_kab = (Spinner) findViewById(R.id.kabupaten);
        Spinner spinner_kec = (Spinner) findViewById(R.id.kecamatan);

        spinner.setAdapter(createAdapter(R.array.Provinsi));
        spinner_kab.setAdapter(createAdapter(R.array.Kabupaten_Kota));
        spinner_kec.setAdapter(createAdapter(R.array.Kecamatan));
    }

    public ArrayAdapter<CharSequence> createAdapter(int resource_id) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, resource_id, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
    }
}