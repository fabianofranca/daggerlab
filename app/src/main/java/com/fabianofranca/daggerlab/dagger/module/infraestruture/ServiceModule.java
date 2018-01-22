package com.fabianofranca.daggerlab.dagger.module.infraestruture;

import com.fabianofranca.daggerlab.infraestruture.services.BaseUrl;
import com.fabianofranca.daggerlab.infraestruture.services.GitHubService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ServiceModule {

    @Provides
    @Singleton
    GitHubService providesGitHubApi(BaseUrl baseUrl) {
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpBuilder.addInterceptor(logging);

        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl(baseUrl.getUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpBuilder.build())
                .build();

        return retrofit.create(GitHubService.class);
    }
}