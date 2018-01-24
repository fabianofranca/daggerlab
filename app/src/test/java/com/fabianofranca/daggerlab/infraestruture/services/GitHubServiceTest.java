package com.fabianofranca.daggerlab.infraestruture.services;

import com.fabianofranca.daggerlab.domain.entity.Repo;
import com.fabianofranca.daggerlab.infraestruture.services.base.GitHubServiceBaseTest;
import com.fabianofranca.daggerlab.infraestruture.services.dto.SearchResult;
import com.fabianofranca.daggerlab.tools.RequestException;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class GitHubServiceTest extends GitHubServiceBaseTest {

    @Test
    public void getRepositories_isCorrect() throws Exception {

        GitHubService service = GitHubServiceMock.setupGetRepositoriesSuccessMock(this);

        SearchResult response = service
                .searchRepositories(1).execute();

       List<Repo> repositories =  response.getRepositories();

        Assert.assertEquals("/search/repositories?q=license:mit&sort=stars&page=1",
                getServer().takeRequest().getPath());

        Assert.assertEquals(repositories.size(), 3);
        Assert.assertEquals(repositories.get(0).getName(), "bootstrap");
        Assert.assertEquals(repositories.get(1).getName(), "react");
        Assert.assertEquals(repositories.get(2).getName(), "vue");
    }

    @Test(expected = RequestException.class)
    public void getRepositories_failed() throws Exception{
        GitHubServiceMock.setupGetRepositoriesFailedMock(this);

        getService().searchRepositories(1).execute();
    }
}