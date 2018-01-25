package com.fabianofranca.daggerlab.tools.retrofit.dagger;

import com.fabianofranca.daggerlab.domain.ServiceFactory;
import com.fabianofranca.daggerlab.tools.retrofit.RetrofitServiceFactory;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class RetrofitModule {

    @Singleton
    @Binds
    abstract ServiceFactory bindServiceFactory(RetrofitServiceFactory factory);
}
