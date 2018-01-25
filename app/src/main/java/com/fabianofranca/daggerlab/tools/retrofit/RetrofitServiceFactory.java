package com.fabianofranca.daggerlab.tools.retrofit;

import com.fabianofranca.daggerlab.domain.ServiceFactory;
import com.fabianofranca.daggerlab.infraestruture.services.BaseUrl;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServiceFactory implements ServiceFactory {

    BaseUrl baseUrl;

    @Inject
    public RetrofitServiceFactory(BaseUrl baseUrl) {
        this.baseUrl =  baseUrl;
    }

    @Override
    public <T> T createService(Class<T> service) {
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpBuilder.addInterceptor(logging);

        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl(baseUrl.getUrl())
                .addCallAdapterFactory(DomainCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpBuilder.build())
                .build();

        return retrofit.create(service);
    }
}
