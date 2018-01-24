package com.fabianofranca.daggerlab.tools.retrofit;

import com.fabianofranca.daggerlab.domain.Request;
import com.fabianofranca.daggerlab.tools.RequestException;
import com.fabianofranca.daggerlab.tools.Result;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitRequest<T> implements Request<T> {

    private Call<T> call;

    public RetrofitRequest(Call<T> call) {
        this.call = call;
    }

    @Override
    public void call(final Result<T> result) {
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                result.success(response.body());
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                result.failure(t);
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