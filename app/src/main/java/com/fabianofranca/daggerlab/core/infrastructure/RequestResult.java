package com.fabianofranca.daggerlab.core.infrastructure;

@FunctionalInterface
public interface RequestResult<T> {
    void success(T data);
}