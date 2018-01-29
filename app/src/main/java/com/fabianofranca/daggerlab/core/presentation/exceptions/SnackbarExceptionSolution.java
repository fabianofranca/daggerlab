package com.fabianofranca.daggerlab.core.presentation.exceptions;

import android.graphics.Color;
import android.view.View;

import android.support.design.widget.Snackbar;

import javax.inject.Inject;

public class SnackbarExceptionSolution implements ExceptionSolution {

    @Inject
    public SnackbarExceptionSolution() {
    }

    @Override
    public boolean canSolve(Throwable throwable) {
        return true;
    }

    @Override
    public void resolver(Throwable throwable, ExceptionContext context) {

        if (context instanceof SnackbarExceptionContext) {
            View view = ((SnackbarExceptionContext)context).getContext();

            Snackbar snackbar = Snackbar.make(view, throwable.getLocalizedMessage(),
                    Snackbar.LENGTH_INDEFINITE)
                    .setActionTextColor(Color.WHITE);

            snackbar.show();

            snackbar.setAction("OK", (v) -> snackbar.dismiss());
        }
    }
}