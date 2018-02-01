package com.fabianofranca.daggerlab.core.presentation.exceptions;

@FunctionalInterface
public interface ExceptionSolver {
    boolean canSolve(Throwable throwable);
}