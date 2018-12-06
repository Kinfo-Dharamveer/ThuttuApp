package com.kinfo.thuttu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kinfo.thuttu.events.Events;
import com.kinfo.thuttu.utils.RxBusSecondActivity;


public class RxBusActivity extends AppCompatActivity {

    public static final String TAG = RxBusActivity.class.getSimpleName();
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_bus);
        button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AppController) getApplication()).bus().send(new Events.TapEvent());
                startActivity(new Intent(RxBusActivity.this, RxBusSecondActivity.class));
            }
        });


    }


}
