package com.fabianofranca.daggerlab.infraestruture.services;

import com.fabianofranca.daggerlab.infraestruture.services.base.GitHubServiceBaseTest;

import okhttp3.mockwebserver.MockResponse;

public class GitHubServiceMock {

    public static final String GET_REPOSITORIES_SUCCESS_JSON = "get_repositories_success.json";

    public static GitHubService setupGetRepositoriesSuccessMock(GitHubServiceBaseTest test)
            throws Exception {

        String json = test.getStringFileContent(GET_REPOSITORIES_SUCCESS_JSON);

        test.getServer().enqueue(new MockResponse().setBody(json));

        return test.getService();
    }

    public static GitHubService setupGetRepositoriesFailedMock(GitHubServiceBaseTest test)
            throws Exception {

        test.getServer().enqueue(new MockResponse().setResponseCode(500));

        return test.getService();
    }
}