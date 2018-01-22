package com.fabianofranca.daggerlab.dagger.module.presentation;

import com.fabianofranca.daggerlab.dagger.scope.ActivityScope;
import com.fabianofranca.daggerlab.presentation.main.MainActivity;
import com.fabianofranca.daggerlab.presentation.main.MainContract;
import com.fabianofranca.daggerlab.presentation.main.MainPresenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MainModule {

    @Binds
    @ActivityScope
    abstract MainContract.Presenter bindPresenter(MainPresenter presenter);

    @Binds
    @ActivityScope
    abstract MainContract.View bindView(MainActivity mainActivity);
}