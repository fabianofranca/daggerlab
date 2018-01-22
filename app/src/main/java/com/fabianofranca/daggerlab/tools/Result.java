package com.fabianofranca.daggerlab.tools;

public interface Result<T> {
    void success(T data);
    void failure(Throwable throwable);
}