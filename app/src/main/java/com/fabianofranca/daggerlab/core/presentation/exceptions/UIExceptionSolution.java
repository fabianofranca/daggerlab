package com.fabianofranca.daggerlab.core.presentation.exceptions;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

public abstract class UIExceptionSolution extends ExceptionSolution implements LifecycleObserver {

    private ExceptionHandler exceptionHandler;

    public UIExceptionSolution(Lifecycle lifecycle, ExceptionHandler exceptionHandler,
                               ExceptionSolver exceptionSolver) {

        super(exceptionSolver);

        this.exceptionHandler = exceptionHandler;

        lifecycle.addObserver(this);
    }

    @Override
    public abstract void solve(Throwable throwable);

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void addSolution() {
        exceptionHandler.addSolution(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void removeSolution() {
        exceptionHandler.removeSolution(this);
    }
}