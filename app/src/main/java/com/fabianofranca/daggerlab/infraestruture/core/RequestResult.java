package com.fabianofranca.daggerlab.infraestruture.core;

@FunctionalInterface
public interface RequestResult<T> {
    void success(T data);
}