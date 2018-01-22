package com.fabianofranca.daggerlab.infraestruture.services;

import com.fabianofranca.daggerlab.domain.models.Repo;
import com.fabianofranca.daggerlab.infraestruture.services.base.GitHubServiceBaseTest;
import com.fabianofranca.daggerlab.infraestruture.services.dto.SearchResult;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import retrofit2.Response;

import static org.junit.Assert.*;

public class GitHubServiceTest extends GitHubServiceBaseTest {

    @Test
    public void getRepositories_isCorrect() throws Exception {

        GitHubService service = GitHubServiceMock.setupGetRepositoriesSuccessMock(this);

        Response<SearchResult> response = service
                .searchRepositories(1)
                .execute();

        List<Repo> repositories =  response
                .body()
                .getRepositories();

        Assert.assertEquals("/search/repositories?q=license:mit&sort=stars&page=1",
                getServer().takeRequest().getPath());

        Assert.assertTrue(response.isSuccessful());
        Assert.assertEquals(repositories.size(), 3);
        Assert.assertEquals(repositories.get(0).getName(), "bootstrap");
        Assert.assertEquals(repositories.get(1).getName(), "react");
        Assert.assertEquals(repositories.get(2).getName(), "vue");
    }

    @Test
    public void getRepositories_failed() throws Exception {
        GitHubService service = GitHubServiceMock.setupGetRepositoriesFailedMock(this);

        Response<SearchResult> response = service
                .searchRepositories(1)
                .execute();

        assertEquals("/search/repositories?q=license:mit&sort=stars&page=1",
                getServer().takeRequest().getPath());
        assertFalse(response.isSuccessful());
        assertEquals(500, response.code());
    }
}