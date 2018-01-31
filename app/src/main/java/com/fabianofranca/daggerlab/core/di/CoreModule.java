package com.fabianofranca.daggerlab.core.di;

import com.fabianofranca.daggerlab.core.infrastructure.UIThreadFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CoreModule {

    @Singleton
    @Provides
    UIThreadFactory provideUIThreadFactory() {
        return new UIThreadFactory();
    }
}