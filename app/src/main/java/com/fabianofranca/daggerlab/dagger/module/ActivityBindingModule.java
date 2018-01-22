package com.fabianofranca.daggerlab.dagger.module;

import com.fabianofranca.daggerlab.presentation.main.MainActivity;
import com.fabianofranca.daggerlab.dagger.module.presentation.MainModule;
import com.fabianofranca.daggerlab.dagger.scope.ActivityScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = { MainModule.class})
    abstract MainActivity mainActivity();
}