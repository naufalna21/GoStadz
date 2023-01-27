package com.naufal.gostadzfix.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.naufal.gostadzfix.R;
import com.naufal.gostadzfix.helper.MoveActivity;

public class ListOrderUstadzScreen extends AppCompatActivity {
    RelativeLayout Us1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_order_ustadz_screen);
        Us1 = findViewById(R.id.Us1);
        Us1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MoveActivity.toScheduleOrderUstadzScreen(getApplicationContext());
            }
        });
    }
}