package com.fabianofranca.daggerlab.dagger;

import android.app.Application;

import com.fabianofranca.daggerlab.DaggerLabApplication;
import com.fabianofranca.daggerlab.dagger.module.ActivityBindingModule;
import com.fabianofranca.daggerlab.dagger.module.ApplicationModule;
import com.fabianofranca.daggerlab.dagger.module.infraestruture.BaseUrlModule;
import com.fabianofranca.daggerlab.dagger.module.infraestruture.manager.GitHubManagerModule;
import com.fabianofranca.daggerlab.dagger.module.infraestruture.ServiceModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class,
        BaseUrlModule.class,
        ServiceModule.class,
        GitHubManagerModule.class})
public interface ApplicationComponent extends AndroidInjector<DaggerLabApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        ApplicationComponent.Builder application(Application application);

        ApplicationComponent build();
    }
}