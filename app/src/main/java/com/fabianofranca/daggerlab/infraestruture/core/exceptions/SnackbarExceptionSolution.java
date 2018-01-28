package com.fabianofranca.daggerlab.infraestruture.core.exceptions;

import android.util.Log;

public class SnackbarExceptionSolution implements ExceptionSolution {
    @Override
    public boolean hasSolution(Throwable throwable) {
        return true;
    }

    @Override
    public void resolve(Throwable throwable) {
        Log.d(this.getClass().getName(), "Resolve");
    }
}
