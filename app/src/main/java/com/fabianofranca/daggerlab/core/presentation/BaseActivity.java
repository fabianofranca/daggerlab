package com.fabianofranca.daggerlab.core.presentation;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.fabianofranca.daggerlab.core.presentation.exceptions.ExceptionHandler;
import com.fabianofranca.daggerlab.core.presentation.exceptions.ExceptionSolver;
import com.fabianofranca.daggerlab.core.presentation.exceptions.SnackbarExceptionSolution;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {

    @Inject
    ExceptionHandler exceptionHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SnackbarExceptionSolution.create(
                getLifecycle(),
                exceptionHandler,
                () -> findViewById(android.R.id.content),
                getExceptionSolver());
    }

    protected ExceptionSolver getExceptionSolver() {
        return (throwable) -> true;
    }
}