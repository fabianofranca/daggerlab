package com.fabianofranca.daggerlab.core.infrastructure;

public class UIThreadFactory {

    public <T> SuccessRequest<T> getSuccessRequest(SuccessRequest<T> successRequest) {
        return  new UISuccessRequest(successRequest);
    }

    public FailureRequest getFailureRequest(FailureRequest failureRequest) {
        return  new UIFailureRequest(failureRequest);
    }
}