package com.fabianofranca.daggerlab.core.di;

import com.fabianofranca.daggerlab.core.presentation.exceptions.ExceptionResolve;
import com.fabianofranca.daggerlab.core.presentation.exceptions.ExceptionSolution;

import java.util.Collections;
import java.util.Set;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;

@Module
public class ExceptionsModule {

    @Singleton
    @Provides
    ExceptionResolve provideExceptionHandler(Set<ExceptionSolution> solutions) {
        return new ExceptionResolve(solutions);
    }

    @Provides
    @ElementsIntoSet
    Set<ExceptionSolution> proviceExceptionSolutions() {
        return Collections.emptySet();
    }
}