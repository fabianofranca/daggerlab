package com.fabianofranca.daggerlab.main;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MainModule {

    @Binds
    abstract MainPresenterContract provideMainPresenterContract(MainPresenter presenter);
}
