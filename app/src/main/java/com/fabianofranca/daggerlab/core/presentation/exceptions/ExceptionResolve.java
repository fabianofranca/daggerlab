package com.fabianofranca.daggerlab.core.presentation.exceptions;

import java.util.Iterator;
import java.util.List;

public class ExceptionResolve {

    private List<SolutionMap> solutionMaps;

    private ExceptionContext exceptionContext;

    public void resolver(Throwable throwable) {

        solutionMaps.

        if (!solutionMaps.isEmpty()) {

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