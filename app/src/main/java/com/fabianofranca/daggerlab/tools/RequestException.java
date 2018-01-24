package com.fabianofranca.daggerlab.tools;

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
