package com.kinfo.thuttu.di.components;


import com.kinfo.thuttu.BaseActivity;
import com.kinfo.thuttu.BaseFragment;
import com.kinfo.thuttu.di.modules.HttpModule;
import com.kinfo.thuttu.di.modules.SharedPrefHelper;
import com.kinfo.thuttu.network.GitApiInterface;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {HttpModule.class, SharedPrefHelper.class})
public interface AppComponent {

        void inject(BaseActivity activity);
        void inject(BaseFragment baseFragment);

        GitApiInterface api();

}
