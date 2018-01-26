package com.fabianofranca.daggerlab.infraestruture.services.core.retrofit;

import android.support.annotation.Nullable;

import com.fabianofranca.daggerlab.infraestruture.services.core.Request;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;

public final class DomainCallAdapterFactory extends CallAdapter.Factory {

    public static DomainCallAdapterFactory create() {
        return new DomainCallAdapterFactory();
    }

    private DomainCallAdapterFactory() {
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