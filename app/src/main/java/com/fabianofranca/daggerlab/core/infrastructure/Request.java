package com.fabianofranca.daggerlab.core.infrastructure;

public interface Request<T> {
    void call(RequestResult<T> requestResult);
    T execute();
}