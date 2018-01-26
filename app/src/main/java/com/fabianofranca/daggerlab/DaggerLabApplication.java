package com.fabianofranca.daggerlab;

import com.fabianofranca.daggerlab.di.DaggerApplicationComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class DaggerLabApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerApplicationComponent.builder().application(this).build();
    }
}
