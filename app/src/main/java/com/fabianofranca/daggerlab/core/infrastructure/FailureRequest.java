package com.fabianofranca.daggerlab.core.infrastructure;

@FunctionalInterface
public interface FailureRequest {
    void fail(Throwable throwable);
}