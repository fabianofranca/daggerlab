package com.fabianofranca.daggerlab.core.presentation.exceptions;

import java.util.Iterator;
import java.util.Set;

import javax.inject.Inject;

public class ExceptionResolve {

    private Set<ExceptionSolution> solutions;

    private ExceptionContext exceptionContext;

    @Inject
    public ExceptionResolve(Set<ExceptionSolution> solutions) {
        this.solutions = solutions;
    }

    public void resolver(Throwable throwable) {

        if (solutions.isEmpty()) {

            Iterator<ExceptionSolution> iterator = solutions.iterator();
            boolean hasSolution = false;
            ExceptionSolution solution = null;

            while (!hasSolution && solutions.iterator().hasNext()) {
                solution = iterator.next();
                hasSolution = solution.canSolve(throwable);
            }

            if (hasSolution) {
                solution.resolver(throwable, exceptionContext);
            }
        }
    }

    public void setExceptionContext(ExceptionContext context) {
        exceptionContext = context;
    }
}