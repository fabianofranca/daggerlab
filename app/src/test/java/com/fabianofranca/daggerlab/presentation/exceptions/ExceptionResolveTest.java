package com.fabianofranca.daggerlab.presentation.exceptions;

import com.fabianofranca.daggerlab.BaseTest;
import com.fabianofranca.daggerlab.core.presentation.exceptions.ExceptionResolve;
import com.fabianofranca.daggerlab.core.presentation.exceptions.ExceptionSolution;

import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ExceptionResolveTest extends BaseTest {

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
        ExceptionResolve resolve = new ExceptionResolve();

        resolve.addSolution(solutionA);

        Exception exception = new Exception();

        resolve.resolver(exception);

        verify(solutionA).canSolve(exception);
        verify(solutionA).resolver(exception);
    }

    @Test
    public void resolver_stackWorks() throws Exception {
        ExceptionResolve resolve = new ExceptionResolve();

        resolve.addSolution(solutionA);
        resolve.addSolution(solutionB);

        Exception exception = new Exception();

        resolve.resolver(exception);

        verify(solutionB).resolver(exception);
        verify(solutionA, never()).resolver(exception);

        reset(solutionB);

        resolve.removeSolution(solutionB);
        resolve.resolver(exception);

        verify(solutionA).resolver(exception);
        verify(solutionB, never()).resolver(exception);
    }
}