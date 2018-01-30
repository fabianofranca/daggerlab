package com.fabianofranca.daggerlab.core.presentation.exceptions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class ExceptionResolve {

    private Deque<SolutionMap> stack;

    public ExceptionResolve() {
        stack = new ArrayDeque<>();
    }

    public void resolver(Throwable throwable) {

        if (!stack.isEmpty()) {

            Iterator<SolutionMap> iterator = stack.iterator();

            ExceptionSolution solution = null;

            while (solution == null && stack.iterator().hasNext()) {
                SolutionMap map = iterator.next();
                solution = map.getSolution(throwable);
            }

            if (solution != null) {
                solution.resolver(throwable);
            }
        }
    }

    public void addSolutionMap(SolutionMap map) {
        stack.push(map);
    }

    public void removeSolutionMap(SolutionMap map) {
        stack.remove(map);
    }
}