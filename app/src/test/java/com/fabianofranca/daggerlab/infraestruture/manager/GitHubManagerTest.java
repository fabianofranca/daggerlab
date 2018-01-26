package com.fabianofranca.daggerlab.infraestruture.manager;

import com.fabianofranca.daggerlab.BaseTest;
import com.fabianofranca.daggerlab.infraestruture.manager.GitHub.GitHubManager;
import com.fabianofranca.daggerlab.infraestruture.services.GitHubService;
import com.fabianofranca.daggerlab.infraestruture.services.dto.SearchResult;
import com.fabianofranca.daggerlab.infraestruture.services.core.Result;
import com.fabianofranca.daggerlab.infraestruture.services.core.retrofit.RetrofitRequest;

import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GitHubManagerTest extends BaseTest {

    @Mock
    private GitHubService service;

    @Mock
    private Result<SearchResult> result;

    @Mock
    private RetrofitRequest<SearchResult> request;

    @Test
    public void getRepositories_isCorrect() throws Exception {

        GitHubManager manager = new GitHubManager(service);

        when(service.searchRepositories(anyInt())).thenReturn(request);

        manager.getRepositories(1, result);

        verify(request).call(result);
    }
}