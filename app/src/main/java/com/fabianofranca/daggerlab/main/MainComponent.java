package com.fabianofranca.daggerlab.main;

import dagger.BindsInstance;
import dagger.Subcomponent;

@Subcomponent(modules = MainModule.class)
public interface MainComponent {

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance Builder view(MainViewContract view);
        MainComponent build();
    }

    void inject(MainActivity activity);
}
