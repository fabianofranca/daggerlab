package com.fabianofranca.daggerlab.di.module.infraestruture;

import com.fabianofranca.daggerlab.infraestruture.core.BaseUrl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class BaseUrlModule {

    //private static final String BASE_URL = "https://api.github.com/";
    private static final String BASE_URL = "https://bb50820d-9c09-4037-942c-1f628b6a947e.mock.pstmn.io/";

    @Singleton
    @Provides
    BaseUrl providesBaseUrl() {
        return new BaseUrl(BASE_URL) ;
    }
}
