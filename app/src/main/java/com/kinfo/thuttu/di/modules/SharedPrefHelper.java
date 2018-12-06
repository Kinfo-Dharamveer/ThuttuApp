package com.kinfo.thuttu.di.modules;

import android.content.Context;
import android.content.SharedPreferences;

import com.kinfo.thuttu.AppController;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SharedPrefHelper {

    private SharedPreferences mSharedPref;

    public SharedPrefHelper(AppController appController) {
        mSharedPref = appController.getSharedPreferences("thuttu", Context.MODE_PRIVATE);
    }


    @Provides
    @Singleton
    public SharedPrefHelper provideSharedPreferences(){
        return this;
    }

    public void put(String key, String value) {
        mSharedPref.edit().putString(key, value).apply();
    }

    public void put(String key, int value) {
        mSharedPref.edit().putInt(key, value).apply();
    }

    public void put(String key, float value) {
        mSharedPref.edit().putFloat(key, value).apply();
    }

    public void put(String key, boolean value) {
        mSharedPref.edit().putBoolean(key, value).apply();
    }

    public String get(String key, String defaultValue) {
        return mSharedPref.getString(key, defaultValue);
    }

    public Integer get(String key, int defaultValue) {
        return mSharedPref.getInt(key, defaultValue);
    }

    public Float get(String key, float defaultValue) {
        return mSharedPref.getFloat(key, defaultValue);
    }

    public Boolean get(String key, boolean defaultValue) {
        return mSharedPref.getBoolean(key, defaultValue);
    }


}
