package com.fabianofranca.daggerlab.core.infrastructure.retrofit;

import android.support.annotation.Nullable;

import com.fabianofranca.daggerlab.core.infrastructure.Request;
import com.fabianofranca.daggerlab.core.presentation.exceptions.ExceptionResolve;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitRequestCallAdapterFactory extends CallAdapter.Factory {

    private ExceptionResolve exceptionResolve;

    @Inject
    public RetrofitRequestCallAdapterFactory(ExceptionResolve exceptionResolve) {
        this.exceptionResolve = exceptionResolve;
    }

    @Nullable
    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        if (getRawType(returnType) != Request.class) {
            return null;
        }

        Type innerType = getParameterUpperBound(0, (ParameterizedType) returnType);

        if (getRawType(innerType) != Response.class) {
            return new BodyCallAdapter<>(innerType, exceptionResolve);
        }

        return null;
    }

    private static final class BodyCallAdapter<R> implements CallAdapter<R, Request<R>> {

        private final Type responseType;
        private ExceptionResolve exceptionResolve;

        public BodyCallAdapter(Type responseType, ExceptionResolve exceptionResolve) {
            this.responseType = responseType;
            this.exceptionResolve = exceptionResolve;
        }

        @Override
        public Type responseType() {
            return responseType;
        }

        @Override
        public Request<R> adapt(Call<R> call) {
            return new RetrofitRequest<>(call, exceptionResolve);
        }
    }
}