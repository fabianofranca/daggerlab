package com.fabianofranca.daggerlab.tools;

public interface BaseRequest<T> {
    void go(Result<T> result);
}
