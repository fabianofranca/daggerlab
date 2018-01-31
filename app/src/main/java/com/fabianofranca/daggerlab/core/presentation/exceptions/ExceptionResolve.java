package com.fabianofranca.daggerlab.core.presentation.exceptions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class ExceptionResolve {

    private Deque<ExceptionSolution> solutions;

    public ExceptionResolve() {
        solutions = new ArrayDeque<>();
    }

    public void resolver(Throwable throwable) {

        if (!solutions.isEmpty()) {

            Iterator<ExceptionSolution> iterator = solutions.iterator();

            ExceptionSolution solution = null;

            while (solution == null && solutions.iterator().hasNext()) {
                ExceptionSolution nextSolution = iterator.next();
                if (nextSolution.canSolve(throwable)) {
                    solution = nextSolution;
                }
            }

            if (solution != null) {
                solution.resolver(throwable);
            }
        }
    }

    public void addSolution(ExceptionSolution solution) {
        solutions.push(solution);
    }

    public void removeSolution(ExceptionSolution solution) {
        solutions.remove(solution);
    }
}