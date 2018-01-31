package com.fabianofranca.daggerlab.core.infrastructure.retrofit;

import android.support.annotation.NonNull;

import com.fabianofranca.daggerlab.core.infrastructure.Request;
import com.fabianofranca.daggerlab.core.infrastructure.FailureRequest;
import com.fabianofranca.daggerlab.core.infrastructure.SuccessRequest;
import com.fabianofranca.daggerlab.core.presentation.exceptions.NetworkException;
import com.fabianofranca.daggerlab.core.presentation.exceptions.RequestException;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitRequest<T> implements Request<T>, Callback<T>{

    private Call<T> call;
    private SuccessRequest<T> successRequest;
    private FailureRequest failureRequest;

    public RetrofitRequest(Call<T> call) {
        this.call = call;
    }

    @Override
    public Request<T> success(@NonNull SuccessRequest<T> successRequest) {
        this.successRequest = successRequest;
        return this;
    }

    @Override
    public Request<T> fail(@NonNull FailureRequest failureRequest) {
        this.failureRequest = failureRequest;
        return this;
    }

    @Override
    public void call() {
        if (successRequest == null) {
            throw new RuntimeException("SuccessRequest undefined. Use success() method.");
        }

        call.enqueue(this);
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

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            successRequest.success(response.body());
        } else if (failureRequest != null) {
            failureRequest.fail(new RequestException(response.message(), response.code()));
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (failureRequest != null) {
            failureRequest.fail(new NetworkException(t));
        }
    }
}