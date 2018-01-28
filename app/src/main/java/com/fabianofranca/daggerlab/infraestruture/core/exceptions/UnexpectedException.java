package com.fabianofranca.daggerlab.infraestruture.core.exceptions;

public class UnexpectedException extends RuntimeException {

    public UnexpectedException(Throwable cause) {
        super(cause);
    }
}