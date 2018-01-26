package com.fabianofranca.daggerlab.infraestruture.services.core;

public interface Result<T> {
    void success(T data);
    void failure(Throwable throwable);
}