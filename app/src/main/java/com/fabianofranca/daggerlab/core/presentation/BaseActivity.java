package com.fabianofranca.daggerlab.core.presentation;

import android.view.View;

import com.fabianofranca.daggerlab.core.presentation.exceptions.ExceptionResolve;
import com.fabianofranca.daggerlab.core.presentation.exceptions.SnackbarExceptionContext;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class BaseActivity extends DaggerAppCompatActivity implements SnackbarExceptionContext {

    @Inject
    ExceptionResolve exceptionResolve;

    @Override
    protected void onResume() {
        super.onResume();
        exceptionResolve.setExceptionContext(this);
    }

    @Override
    public View getContext() {
        return getBaseViewToShowSnackBar();
    }

    protected View getBaseViewToShowSnackBar() {
        return getWindow().getDecorView().findViewById(android.R.id.content);
    }
}