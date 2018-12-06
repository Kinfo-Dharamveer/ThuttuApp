package com.kinfo.thuttu.utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.kinfo.thuttu.AppController;
import com.kinfo.thuttu.R;
import com.kinfo.thuttu.events.Events;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RxBusSecondActivity extends AppCompatActivity {

    private final CompositeDisposable disposables = new CompositeDisposable();
    TextView textView;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposables.clear(); // do not send event after activity has been destroyed
    }



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_bus_second);
        textView =  findViewById(R.id.textView);

        EventBus.getDefault().register(this); // this == your class instance


        disposables.add(((AppController) getApplication())
                .bus()
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object object) throws Exception {
                        if (object instanceof Events.AutoEvent) {
                            textView.setText("Auto Event Received");
                        } else if (object instanceof Events.TapEvent) {
                            textView.setText("Tap Event Received");
                        }
                    }
                }));

        ((AppController)  getApplication()).bus().toObservable().subscribe(new Consumer<Object>()
        {
            @Override
            public void accept(Object o) throws Exception {

                if (o instanceof Events) {

                    textView.setText("Tap Event Received");

                }

            }
        });

    }

}
