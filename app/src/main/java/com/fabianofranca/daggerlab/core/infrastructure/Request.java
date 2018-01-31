package com.fabianofranca.daggerlab.core.infrastructure;

public interface Request<T> {
    Request<T> success(SuccessRequest<T> successRequest);
    Request<T> fail(FailureRequest failureRequest);
    void call();
    T execute();
}