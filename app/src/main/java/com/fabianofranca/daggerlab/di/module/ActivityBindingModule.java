package com.fabianofranca.daggerlab.di.module;

import com.fabianofranca.daggerlab.presentation.main.MainActivity;
import com.fabianofranca.daggerlab.di.module.presentation.MainModule;
import com.fabianofranca.daggerlab.di.scope.ActivityScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = { MainModule.class})
    abstract MainActivity mainActivity();
}