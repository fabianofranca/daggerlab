package com.fabianofranca.daggerlab.di.module.infraestruture;


import com.fabianofranca.daggerlab.infrastructure.services.GitHubService;
import com.fabianofranca.daggerlab.core.infrastructure.BaseUrl;
import com.fabianofranca.daggerlab.core.infrastructure.retrofit.RetrofitServiceFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ServicesModule {

    @Singleton
    @Provides
    GitHubService provideGitHubService(RetrofitServiceFactory<GitHubService> serviceFactory
            , BaseUrl baseUrl) {

        return serviceFactory.createService(baseUrl, GitHubService.class);
    }
}