package com.fabianofranca.daggerlab.di;

import com.fabianofranca.daggerlab.main.MainActivity;
import com.fabianofranca.daggerlab.main.MainModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity mainActivity();
}
