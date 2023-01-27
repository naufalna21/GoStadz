package com.naufal.gostadzfix.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.naufal.gostadzfix.R;

public class ScheduleOrderUstadzScreen extends AppCompatActivity {
    private TextView j2;
    Dialog mDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_order_ustadz_screen);

        j2 = findViewById(R.id.j2);
        mDialog = new Dialog(this);

        j2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.setContentView(R.layout.popup_afterclickorder);

                mDialog.getWindow();

            }
        });
    }
}