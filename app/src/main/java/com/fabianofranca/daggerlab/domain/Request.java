package com.fabianofranca.daggerlab.domain;

import com.fabianofranca.daggerlab.tools.Result;

public interface Request<T> {
    void call(Result<T> result);
    T execute();
}