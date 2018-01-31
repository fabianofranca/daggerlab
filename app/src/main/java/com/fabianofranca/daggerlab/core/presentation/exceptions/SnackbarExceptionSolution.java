package com.fabianofranca.daggerlab.core.presentation.exceptions;

import android.arch.lifecycle.Lifecycle;
import android.graphics.Color;
import android.view.View;

import android.support.design.widget.Snackbar;

public class SnackbarExceptionSolution extends UIExceptionSolution {

    private View view;

    public SnackbarExceptionSolution(Lifecycle lifecycle, ExceptionResolve exceptionResolve,
                                     View view) {

        super(lifecycle, exceptionResolve);
        this.view = view;
    }

    @Override
    public boolean canSolve(Throwable throwable) {
        return true;
    }

    @Override
    public void resolver(Throwable throwable) {

        Snackbar snackbar = Snackbar.make(view, throwable.getLocalizedMessage(),
                Snackbar.LENGTH_INDEFINITE)
                .setActionTextColor(Color.WHITE);

        snackbar.show();

        snackbar.setAction("OK", (v) -> snackbar.dismiss());
    }
}