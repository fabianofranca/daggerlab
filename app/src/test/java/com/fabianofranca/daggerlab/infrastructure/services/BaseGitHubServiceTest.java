package com.fabianofranca.daggerlab.infrastructure.services;

import com.fabianofranca.daggerlab.BaseTest;
import com.fabianofranca.daggerlab.di.DaggerMockGitHubServiceComponent;

import org.junit.After;
import org.junit.Before;

import javax.inject.Inject;

import okhttp3.mockwebserver.MockWebServer;

public abstract class BaseGitHubServiceTest extends BaseTest {

    @Inject
    MockWebServer server;

    @Inject
    GitHubService service;

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();

        DaggerMockGitHubServiceComponent.builder()
                .test(this)
                .build()
                .inject(this);
    }

    public GitHubService getService() {
        return service;
    }

    public MockWebServer getServer() {
        return server;
    }

    @After
    public void tearDown() throws Exception {
        server.shutdown();
    }
}