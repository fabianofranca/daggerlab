package com.fabianofranca.daggerlab.infraestruture.services.base;

import com.fabianofranca.daggerlab.base.BaseTest;
import com.fabianofranca.daggerlab.dagger.DaggerMockGitHubServiceComponent;
import com.fabianofranca.daggerlab.dagger.MockGitHubServiceComponent;
import com.fabianofranca.daggerlab.infraestruture.services.GitHubService;

import org.junit.After;
import org.junit.Before;

import javax.inject.Inject;

import okhttp3.mockwebserver.MockWebServer;

public abstract class GitHubServiceBaseTest extends BaseTest {

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