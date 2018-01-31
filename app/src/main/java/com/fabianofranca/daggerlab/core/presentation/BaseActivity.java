package com.fabianofranca.daggerlab.core.presentation;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.fabianofranca.daggerlab.core.presentation.exceptions.ExceptionResolve;
import com.fabianofranca.daggerlab.core.presentation.exceptions.SnackbarExceptionSolution;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class BaseActivity extends DaggerAppCompatActivity {

    @Inject
    ExceptionResolve exceptionResolve;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new SnackbarExceptionSolution(getLifecycle(), exceptionResolve,
                getWindow().getDecorView().findViewById(android.R.id.content));
    }
}