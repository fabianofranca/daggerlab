package com.fabianofranca.daggerlab.infraestruture.core.exceptions.di;

import com.fabianofranca.daggerlab.infraestruture.core.exceptions.ExceptionHandler;
import com.fabianofranca.daggerlab.infraestruture.core.exceptions.ExceptionSolution;

import java.util.Set;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ExceptionsModule {

    @Singleton
    @Provides
    ExceptionHandler provideExceptionHandler(Set<ExceptionSolution> solutions) {
        return new ExceptionHandler(solutions);
    }
}
