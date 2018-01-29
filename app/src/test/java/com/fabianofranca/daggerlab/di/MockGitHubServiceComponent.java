package com.fabianofranca.daggerlab.di;

import com.fabianofranca.daggerlab.di.module.infraestruture.ServicesModule;
import com.fabianofranca.daggerlab.infrastructure.services.BaseGitHubServiceTest;
import com.fabianofranca.daggerlab.core.di.RetrofitModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {
        RetrofitModule.class,
        MockWebServerModule.class,
        ServicesModule.class})
public interface MockGitHubServiceComponent {

    void inject(BaseGitHubServiceTest test);

    @Component.Builder
    interface Builder {
        @BindsInstance
        MockGitHubServiceComponent.Builder test(BaseGitHubServiceTest test);

        MockGitHubServiceComponent build();
    }
}