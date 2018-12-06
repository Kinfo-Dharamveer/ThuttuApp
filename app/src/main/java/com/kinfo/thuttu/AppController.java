package com.kinfo.thuttu;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;
import com.kinfo.thuttu.di.components.AppComponent;
import com.kinfo.thuttu.di.components.DaggerAppComponent;
import com.kinfo.thuttu.di.modules.HttpModule;
import com.kinfo.thuttu.di.modules.SharedPrefHelper;
import com.kinfo.thuttu.rxbus.RxBus;

import org.greenrobot.eventbus.EventBus;


public class AppController extends Application {

    private AppComponent component;
    private RxBus bus;
    private static AppController mInstance;
    EventBus myEventBus;


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = (AppController)getApplicationContext();

        myEventBus = EventBus.getDefault();

        Stetho.initializeWithDefaults(this);
        bus = new RxBus();

        component = DaggerAppComponent.builder().sharedPrefHelper(new SharedPrefHelper(this))
                .httpModule(new HttpModule(this))
                .build();


    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    public static synchronized AppController getInstance() {
        return mInstance;
    }
    public RxBus bus() {
        return bus;
    }

    public AppComponent getComponent(){
        return component;
    }
}
