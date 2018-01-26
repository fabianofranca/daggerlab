package com.fabianofranca.daggerlab.di.module.infraestruture;

import com.fabianofranca.daggerlab.infraestruture.services.core.BaseUrl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class BaseUrlModule {

    private static final String BASE_URL = "https://api.github.com/";

    @Singleton
    @Provides
    BaseUrl providesBaseUrl() {
        return new BaseUrl(BASE_URL) ;
    }
}
