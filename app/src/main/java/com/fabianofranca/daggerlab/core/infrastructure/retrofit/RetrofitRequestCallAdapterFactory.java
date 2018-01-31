package com.fabianofranca.daggerlab.core.infrastructure.retrofit;

import android.support.annotation.Nullable;

import com.fabianofranca.daggerlab.core.infrastructure.Request;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitRequestCallAdapterFactory extends CallAdapter.Factory {

    @Inject
    public RetrofitRequestCallAdapterFactory() {
        // only for injection
    }

    @Nullable
    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        if (getRawType(returnType) != Request.class) {
            return null;
        }

        Type innerType = getParameterUpperBound(0, (ParameterizedType) returnType);

        if (getRawType(innerType) != Response.class) {
            return new BodyCallAdapter<>(innerType);
        }

        return null;
    }

    private static final class BodyCallAdapter<R> implements CallAdapter<R, Request<R>> {

        private final Type responseType;

        public BodyCallAdapter(Type responseType) {
            this.responseType = responseType;
        }

        @Override
        public Type responseType() {
            return responseType;
        }

        @Override
        public Request<R> adapt(Call<R> call) {
            return new RetrofitRequest<>(call);
        }
    }
}