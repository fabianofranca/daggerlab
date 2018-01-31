package com.fabianofranca.daggerlab.core.infrastructure;

import android.os.Handler;
import android.os.Looper;

public class UISuccessRequest<T> implements SuccessRequest<T> {

    private Handler handler;

    private SuccessRequest<T> success;

    public UISuccessRequest(SuccessRequest<T> success) {
        this.success = success;
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void success(T data) {
        handler.post(() -> success.success(data));
    }
}
