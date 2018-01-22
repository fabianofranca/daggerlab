package com.fabianofranca.daggerlab.dagger;

import com.fabianofranca.daggerlab.dagger.module.infraestruture.ServiceModule;
import com.fabianofranca.daggerlab.infraestruture.services.base.GitHubServiceBaseTest;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = { MockWebServerModule.class, ServiceModule.class } )
public interface MockGitHubServiceComponent {

    void inject(GitHubServiceBaseTest test);

    @Component.Builder
    interface Builder {
        @BindsInstance
        MockGitHubServiceComponent.Builder test(GitHubServiceBaseTest test);

        MockGitHubServiceComponent build();
    }
}