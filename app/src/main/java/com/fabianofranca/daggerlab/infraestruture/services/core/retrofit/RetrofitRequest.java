package com.fabianofranca.daggerlab.infraestruture.services.core.retrofit;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import com.fabianofranca.daggerlab.infraestruture.services.core.Request;
import com.fabianofranca.daggerlab.infraestruture.services.core.RequestException;
import com.fabianofranca.daggerlab.infraestruture.services.core.Result;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitRequest<T> implements Request<T> {

    private Call<T> call;
    private Handler uiThread;

    public RetrofitRequest(Call<T> call) {
        this.call = call;
        uiThread = new Handler(Looper.getMainLooper());
    }

    @Override
    public void call(final Result<T> result) {
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
                uiThread.post( () -> result.success(response.body()));
            }

            @Override
            public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
                uiThread.post( () -> result.failure(t));
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