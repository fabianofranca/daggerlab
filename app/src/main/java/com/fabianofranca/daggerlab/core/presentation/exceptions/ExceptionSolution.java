package com.fabianofranca.daggerlab.core.presentation.exceptions;

public interface ExceptionSolution {
    boolean canSolve(Throwable throwable);
    void resolver(Throwable throwable, ExceptionContext context);
}