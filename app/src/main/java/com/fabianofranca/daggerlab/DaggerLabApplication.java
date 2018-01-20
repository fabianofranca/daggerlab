package com.fabianofranca.daggerlab;

import android.app.Application;

import com.fabianofranca.daggerlab.di.AppComponent;
import com.fabianofranca.daggerlab.di.DaggerAppComponent;

public class DaggerLabApplication extends Application {

    private static DaggerLabApplication app;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        appComponent = DaggerAppComponent.builder()
                .build();
    }

    public static DaggerLabApplication getApp() {
        return app;
    }

    public AppComponent getAppComponent() {
        return  appComponent;
    }
}
