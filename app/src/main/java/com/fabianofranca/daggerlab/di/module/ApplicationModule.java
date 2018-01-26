package com.fabianofranca.daggerlab.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ApplicationModule {

    @Singleton
    @Binds
    abstract Context bindContext(Application application);
}