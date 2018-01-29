package com.fabianofranca.daggerlab.core.presentation.exceptions;

public interface ExceptionContext<T> {
    T getContext();
}