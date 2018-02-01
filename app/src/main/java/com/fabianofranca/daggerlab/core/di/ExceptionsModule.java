package com.fabianofranca.daggerlab.core.di;

import com.fabianofranca.daggerlab.core.presentation.exceptions.ExceptionHandler;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ExceptionsModule {

    @Singleton
    @Provides
    ExceptionHandler provideExceptionResolve() {
        return  new ExceptionHandler();
    }
}