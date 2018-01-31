package com.fabianofranca.daggerlab.core.infrastructure;

import android.os.Handler;
import android.os.Looper;

public class UIFailureRequest implements FailureRequest {

    private Handler handler;

    private FailureRequest failure;

    public UIFailureRequest(FailureRequest failure) {
        this.failure = failure;
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void fail(Throwable throwable) {
        handler.post(() -> failure.fail(throwable));
    }
}