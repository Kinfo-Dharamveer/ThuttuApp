package com.kinfo.thuttu.di.components;


import com.kinfo.thuttu.di.modules.ActivityModule;
import com.kinfo.thuttu.di.scopes.PerActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
}
