package com.fabianofranca.daggerlab.core.infrastructure;

@FunctionalInterface
public interface SuccessRequest<T> {
    void success(T data);
}