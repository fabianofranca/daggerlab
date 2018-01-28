package com.fabianofranca.daggerlab.infraestruture.core.exceptions;

import android.os.Handler;
import android.os.Looper;

import java.util.Iterator;
import java.util.Set;

import javax.inject.Inject;

public class ExceptionHandler {

    Set<ExceptionSolution> solutions;

    private Handler uiThread;

    @Inject
    public ExceptionHandler(Set<ExceptionSolution> solutions) {
        this.solutions = solutions;
        uiThread = new Handler(Looper.getMainLooper());

        Thread.setDefaultUncaughtExceptionHandler(this::uncaughtException);
    }

    void uncaughtException(Thread thread, Throwable throwable) {

        if (solutions.size() > 0) {

            Iterator<ExceptionSolution> iterator = solutions.iterator();
            boolean hasSolution = false;
            ExceptionSolution nextSolution = null;

            while (!hasSolution && solutions.iterator().hasNext()) {
                nextSolution = iterator.next();
                hasSolution = nextSolution.hasSolution(throwable);
            }

            if (hasSolution) {
                final ExceptionSolution finalSolution = nextSolution;
                uiThread.post(() -> finalSolution.resolve(throwable));
            }
        }
    }
}
