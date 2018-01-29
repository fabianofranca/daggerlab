package com.fabianofranca.daggerlab.core.infrastructure.retrofit;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import com.fabianofranca.daggerlab.core.infrastructure.Request;
import com.fabianofranca.daggerlab.core.presentation.exceptions.ExceptionResolve;
import com.fabianofranca.daggerlab.core.presentation.exceptions.NetworkException;
import com.fabianofranca.daggerlab.core.presentation.exceptions.RequestException;
import com.fabianofranca.daggerlab.core.infrastructure.RequestResult;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitRequest<T> implements Request<T> {

    private Call<T> call;
    private Handler uiThread;
    private ExceptionResolve exceptionResolve;

    public RetrofitRequest(Call<T> call, ExceptionResolve exceptionResolve) {
        this.call = call;
        this.uiThread = new Handler(Looper.getMainLooper());
        this.exceptionResolve = exceptionResolve;
    }

    @Override
    public void call(final RequestResult<T> requestResult) {
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
                uiThread.post(() -> {
                    if (response.isSuccessful()) {
                        requestResult.success(response.body());
                    } else {
                        exceptionResolve.resolver(
                                new RequestException(response.message(), response.code()));
                    }
                });
            }

            @Override
            public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
                uiThread.post(() -> exceptionResolve.resolver(new NetworkException(t)));
            }
        });
    }

    @Override
    public T execute() {
        Response<T> response;

        try {
            response = call.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (!response.isSuccessful()) {
            throw new RequestException(response.message(), response.code());
        }

        return response.body();
    }
}