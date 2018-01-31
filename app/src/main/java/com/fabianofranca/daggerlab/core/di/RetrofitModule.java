package com.fabianofranca.daggerlab.core.di;

import com.fabianofranca.daggerlab.core.infrastructure.ServiceFactory;
import com.fabianofranca.daggerlab.core.infrastructure.retrofit.RetrofitRequestCallAdapterFactory;
import com.fabianofranca.daggerlab.core.infrastructure.retrofit.RetrofitServiceFactory;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

@Module
public abstract class RetrofitModule {

    @Singleton
    @Binds
    abstract ServiceFactory bindServiceFactory(RetrofitServiceFactory factory);

    @Singleton
    @Provides
    static OkHttpClient.Builder provideOkHttpClientBuilder() {
        return new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    static Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Singleton
    @Provides
    static HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor();
    }

    @Singleton
    @Binds
    abstract CallAdapter.Factory bindCallAdapterFactory(RetrofitRequestCallAdapterFactory factory);
}