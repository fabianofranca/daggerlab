package com.fabianofranca.daggerlab.core.presentation.exceptions;

import android.arch.lifecycle.Lifecycle;
import android.graphics.Color;

import android.support.design.widget.Snackbar;

import com.fabianofranca.daggerlab.core.presentation.ViewProvider;

public class SnackbarExceptionSolution extends UIExceptionSolution {

    private ViewProvider viewProvider;

    public static SnackbarExceptionSolution create(Lifecycle lifecycle,
                                                   ExceptionHandler exceptionHandler,
                                                   ViewProvider viewProvider,
                                                   ExceptionSolver exceptionSolver) {

        return new SnackbarExceptionSolution(lifecycle, exceptionHandler,
                viewProvider, exceptionSolver);
    }

    private SnackbarExceptionSolution(Lifecycle lifecycle, ExceptionHandler exceptionHandler,
                                     ViewProvider viewProvider, ExceptionSolver exceptionSolver) {

        super(lifecycle, exceptionHandler, exceptionSolver);
        this.viewProvider = viewProvider;
    }

    @Override
    public void solve(Throwable throwable) {

        Snackbar snackbar = Snackbar.make(viewProvider.getView(), throwable.getLocalizedMessage(),
                Snackbar.LENGTH_INDEFINITE)
                .setActionTextColor(Color.WHITE);

        snackbar.show();

        snackbar.setAction("OK", (v) -> snackbar.dismiss());
    }
}