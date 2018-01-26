package com.fabianofranca.daggerlab.infraestruture.services;

import com.fabianofranca.daggerlab.domain.entity.Repo;
import com.fabianofranca.daggerlab.infraestruture.services.core.RequestException;
import com.fabianofranca.daggerlab.infraestruture.services.dto.SearchResult;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GitHubServiceTest extends BaseGitHubServiceTest {

    @Test
    public void getRepositories_isCorrect() throws Exception {

        GitHubService service = GitHubServiceMock.setupGetRepositoriesSuccessMock(this);

        SearchResult response = service
                .searchRepositories(1).execute();

       List<Repo> repositories =  response.getRepositories();

        Assert.assertEquals("/search/repositories?q=license:mit&sort=stars&page=1",
                getServer().takeRequest().getPath());

        assertEquals(repositories.size(), 3);
        assertEquals(repositories.get(0).getName(), "bootstrap");
        assertEquals(repositories.get(1).getName(), "react");
        assertEquals(repositories.get(2).getName(), "vue");
    }

    @Test(expected = RequestException.class)
    public void getRepositories_failed() throws Exception{
        GitHubServiceMock.setupGetRepositoriesFailedMock(this);

        getService().searchRepositories(1).execute();
    }
}