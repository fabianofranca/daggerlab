package com.fabianofranca.daggerlab.core.presentation.exceptions;

public abstract class ExceptionSolution {

    private ExceptionSolver exceptionSolver;

    public ExceptionSolution(ExceptionSolver exceptionSolver) {
        this.exceptionSolver = exceptionSolver;
    }

    public abstract void solve(Throwable throwable);

    public boolean canSolve(Throwable throwable) {
        return exceptionSolver.canSolve(throwable);
    }
}