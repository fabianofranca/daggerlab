package com.fabianofranca.daggerlab.tools.retrofit;

import com.fabianofranca.daggerlab.tools.BaseRequest;
import com.fabianofranca.daggerlab.tools.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitRequest<T> implements BaseRequest<T> {

    private Call<T> call;

    public RetrofitRequest(Call<T> call) {
        this.call = call;
    }

    @Override
    public void go(final Result<T> result) {

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
