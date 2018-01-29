package com.fabianofranca.daggerlab.di;

import com.fabianofranca.daggerlab.core.infrastructure.BaseUrl;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.mockwebserver.MockWebServer;

@Module
public class MockWebServerModule {

    private static final String BASE_URL = "/";

    @Provides
    @Singleton
    MockWebServer providesMockWebServer() {
        MockWebServer server = new MockWebServer();

        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return server;
    }

    @Provides
    @Singleton
    BaseUrl providesBaseUrl(MockWebServer server) {
        return new BaseUrl(server.url(BASE_URL).toString());
    }
}
