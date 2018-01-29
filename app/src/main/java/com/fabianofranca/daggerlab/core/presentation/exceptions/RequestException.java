package com.fabianofranca.daggerlab.core.presentation.exceptions;

public class RequestException extends RuntimeException {

    private int code;

    public RequestException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
