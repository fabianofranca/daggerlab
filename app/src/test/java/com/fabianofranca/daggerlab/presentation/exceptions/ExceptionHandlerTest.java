package com.fabianofranca.daggerlab.presentation.exceptions;

import com.fabianofranca.daggerlab.BaseTest;
import com.fabianofranca.daggerlab.core.presentation.exceptions.ExceptionHandler;
import com.fabianofranca.daggerlab.core.presentation.exceptions.ExceptionSolution;

import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ExceptionHandlerTest extends BaseTest {

    @Mock
    ExceptionSolution solutionA;

    @Mock
    ExceptionSolution solutionB;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        when(solutionA.canSolve(any())).thenReturn(true);
        when(solutionB.canSolve(any())).thenReturn(true);
    }

    @Test
    public void resolver_isCorrect() throws Exception {
        ExceptionHandler resolve = new ExceptionHandler();

        resolve.addSolution(solutionA);

        Exception exception = new Exception();

        resolve.handling(exception);

        verify(solutionA).canSolve(exception);
        verify(solutionA).solve(exception);
    }

    @Test
    public void resolver_stackWorks() throws Exception {
        ExceptionHandler resolve = new ExceptionHandler();

        resolve.addSolution(solutionA);
        resolve.addSolution(solutionB);

        Exception exception = new Exception();

        resolve.handling(exception);

        verify(solutionB).solve(exception);
        verify(solutionA, never()).solve(exception);

        reset(solutionB);

        resolve.removeSolution(solutionB);
        resolve.handling(exception);

        verify(solutionA).solve(exception);
        verify(solutionB, never()).solve(exception);
    }
}