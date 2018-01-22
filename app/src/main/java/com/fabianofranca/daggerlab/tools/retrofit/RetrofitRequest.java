package com.fabianofranca.daggerlab.tools.retrofit;

import com.fabianofranca.daggerlab.tools.BaseRequest;
import com.fabianofranca.daggerlab.tools.Result;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitRequest<T> implements BaseRequest<T> {

    private Call<T> call;

    @Inject
    public RetrofitRequest() {
    }

    public RetrofitRequest<T> call(Call<T> call) {
        this.call = call;
        return this;
    }

    @Override
    public void go(final Result<T> result) {

        if (call == null) {
            throw new RuntimeException("Call<T> instance not found");
        }

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
}
