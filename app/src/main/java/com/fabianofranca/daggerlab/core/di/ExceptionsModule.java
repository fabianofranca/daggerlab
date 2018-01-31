package com.fabianofranca.daggerlab.core.di;

import com.fabianofranca.daggerlab.core.presentation.exceptions.ExceptionResolve;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ExceptionsModule {

    @Singleton
    @Provides
    ExceptionResolve provideExceptionResolve() {
        return  new ExceptionResolve();
    }
}