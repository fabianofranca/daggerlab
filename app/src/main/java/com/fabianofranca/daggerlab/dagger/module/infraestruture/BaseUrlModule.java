package com.fabianofranca.daggerlab.dagger.module.infraestruture;

import com.fabianofranca.daggerlab.infraestruture.services.BaseUrl;

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
