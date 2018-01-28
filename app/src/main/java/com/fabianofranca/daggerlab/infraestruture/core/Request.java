package com.fabianofranca.daggerlab.infraestruture.core;

public interface Request<T> {
    void call(RequestResult<T> requestResult);
    T execute();
}