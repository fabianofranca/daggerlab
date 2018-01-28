package com.fabianofranca.daggerlab.infraestruture.core.exceptions;

public interface ExceptionSolution {
    boolean hasSolution(Throwable throwable);
    void resolve(Throwable throwable);
}