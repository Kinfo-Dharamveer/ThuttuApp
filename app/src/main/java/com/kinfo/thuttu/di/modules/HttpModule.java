package com.kinfo.thuttu.di.modules;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.GsonBuilder;
import com.kinfo.thuttu.BuildConfig;
import com.kinfo.thuttu.AppController;
import com.kinfo.thuttu.network.GitApiInterface;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Module
public class HttpModule {

    private AppController appController;

    public HttpModule(AppController appController) {
        this.appController = appController;
    }

    @Provides
    @Singleton
    public OkHttpClient provideHttpLogging() {
        Cache cache = new Cache(appController.getCacheDir(), 10 * 1024 * 1024);
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);

        return new OkHttpClient.Builder().addInterceptor(loggingInterceptor).addNetworkInterceptor(new StethoInterceptor()).readTimeout(180, TimeUnit.SECONDS).cache(cache).build();
    }


    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.SERVER_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    public GitApiInterface provideApiService(Retrofit retrofit) {
        return retrofit.create(GitApiInterface.class);
    }



}
