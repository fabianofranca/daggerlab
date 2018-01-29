package com.fabianofranca.daggerlab.di;

import android.app.Application;

import com.fabianofranca.daggerlab.DaggerLabApplication;
import com.fabianofranca.daggerlab.di.module.ActivityBindingModule;
import com.fabianofranca.daggerlab.di.module.ApplicationModule;
import com.fabianofranca.daggerlab.di.module.infraestruture.BaseUrlModule;
import com.fabianofranca.daggerlab.di.module.infraestruture.ExceptionSolutionsModule;
import com.fabianofranca.daggerlab.di.module.infraestruture.ServicesModule;
import com.fabianofranca.daggerlab.di.module.infraestruture.manager.GitHubManagerModule;
import com.fabianofranca.daggerlab.core.di.RetrofitModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        ExceptionSolutionsModule.class,
        RetrofitModule.class,
        ApplicationModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class,
        BaseUrlModule.class,
        ServicesModule.class,
        GitHubManagerModule.class})
public interface ApplicationComponent extends AndroidInjector<DaggerLabApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        ApplicationComponent.Builder application(Application application);

        ApplicationComponent build();
    }
}