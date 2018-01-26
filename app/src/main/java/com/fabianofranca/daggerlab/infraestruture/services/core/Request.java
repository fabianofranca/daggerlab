package com.fabianofranca.daggerlab.infraestruture.services.core;

public interface Request<T> {
    void call(Result<T> result);
    T execute();
}