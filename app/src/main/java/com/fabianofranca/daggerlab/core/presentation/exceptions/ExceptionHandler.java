package com.fabianofranca.daggerlab.core.presentation.exceptions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class ExceptionHandler {

    private Deque<ExceptionSolution> solutions;

    public ExceptionHandler() {
        solutions = new ArrayDeque<>();
    }

    public void handling(Throwable throwable) {

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
                solution.solve(throwable);
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