package com.fabianofranca.daggerlab.core.presentation.exceptions;

import java.util.HashMap;
import java.util.Map;

public class SolutionMap {

    private Map<Class<?>, ExceptionSolution> map;

    public SolutionMap() {
        map = new HashMap<>();
    }

    public <T extends Throwable> void addSolution(Class<T> throwableType, ExceptionSolution solution) {
        map.put(throwableType, solution);
    }

    public <T extends Throwable> void removeSolution(Class<T> throwableType) {
        map.remove(throwableType);
    }

    public void addSolutionForAllExceptions(ExceptionSolution solution) {
        map.put(AllExceptions.class, solution);
    }

    public ExceptionSolution getSolution(Throwable throwable) {

        if (map.containsKey(AllExceptions.class)) {
            return map.get(AllExceptions.class);
        }

        if (map.containsKey(throwable.getClass())) {

            ExceptionSolution solution = map.get(throwable.getClass());

            return solution.canSolve(throwable) ? solution : null;
        }

        return null;
    }

    private static class AllExceptions extends Throwable {
        private AllExceptions() {
        }
    }
}