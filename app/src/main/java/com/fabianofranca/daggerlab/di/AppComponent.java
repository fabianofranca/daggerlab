package com.fabianofranca.daggerlab.di;

import com.fabianofranca.daggerlab.main.MainComponent;

import javax.inject.Provider;
import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { AppModule.class })
public interface AppComponent {

    @Component.Builder
    interface Builder {
        AppComponent build();
    }

    Provider<MainComponent.Builder> getMainComponentBuilder();
}
