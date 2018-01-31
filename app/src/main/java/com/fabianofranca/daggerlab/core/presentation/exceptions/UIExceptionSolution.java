package com.fabianofranca.daggerlab.core.presentation.exceptions;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

public abstract class UIExceptionSolution implements ExceptionSolution, LifecycleObserver {

    private ExceptionResolve exceptionResolve;

    public UIExceptionSolution(Lifecycle lifecycle, ExceptionResolve exceptionResolve) {
        this.exceptionResolve = exceptionResolve;

        lifecycle.addObserver(this);
    }

    @Override
    public boolean canSolve(Throwable throwable) {
        return false;
    }

    @Override
    public void resolver(Throwable throwable) {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void addSolution() {
        exceptionResolve.addSolution(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void removeSolution() {
        exceptionResolve.removeSolution(this);
    }
}