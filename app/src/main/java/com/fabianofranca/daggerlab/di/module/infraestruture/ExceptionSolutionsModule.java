package com.fabianofranca.daggerlab.di.module.infraestruture;

import com.fabianofranca.daggerlab.infraestruture.core.exceptions.ExceptionSolution;
import com.fabianofranca.daggerlab.infraestruture.core.exceptions.SnackbarExceptionSolution;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;

@Module
public abstract class ExceptionSolutionsModule {
    @Singleton
    @IntoSet
    @Binds
    abstract ExceptionSolution bindSnackbarExceptionSolution(SnackbarExceptionSolution solution);
}