package com.fabianofranca.daggerlab.infraestruture.core.retrofit;

import com.fabianofranca.daggerlab.infraestruture.core.ServiceFactory;
import com.fabianofranca.daggerlab.infraestruture.core.BaseUrl;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServiceFactory<T> implements ServiceFactory<T> {

    private OkHttpClient.Builder okHttpBuilder;
    private Retrofit.Builder retrofitBuilder;
    private HttpLoggingInterceptor httpLoggingInterceptor;

    @Inject
    public RetrofitServiceFactory(OkHttpClient.Builder okHttpBuilder,
                                  Retrofit.Builder retrofitBuilder,
                                  HttpLoggingInterceptor httpLoggingInterceptor) {

        this.okHttpBuilder = okHttpBuilder;
        this.retrofitBuilder = retrofitBuilder;
        this.httpLoggingInterceptor = httpLoggingInterceptor;
    }

    @Override
    public T createService(BaseUrl baseUrl, Class<T> service) {

        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpBuilder.addInterceptor(httpLoggingInterceptor);

        return retrofitBuilder
                .baseUrl(baseUrl.getUrl())
                .addCallAdapterFactory(DomainCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpBuilder.build())
                .build()
                .create(service);
    }
}