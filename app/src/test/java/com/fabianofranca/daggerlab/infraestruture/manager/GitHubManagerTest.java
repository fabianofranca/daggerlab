package com.fabianofranca.daggerlab.infraestruture.manager;

import com.fabianofranca.daggerlab.base.BaseTest;
import com.fabianofranca.daggerlab.infraestruture.manager.GitHub.GitHubManager;
import com.fabianofranca.daggerlab.infraestruture.services.GitHubService;
import com.fabianofranca.daggerlab.infraestruture.services.dto.SearchResult;
import com.fabianofranca.daggerlab.tools.Result;
import com.fabianofranca.daggerlab.tools.retrofit.RetrofitRequest;

import org.junit.Test;
import org.mockito.Mock;

import retrofit2.Call;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GitHubManagerTest extends BaseTest {

    @Mock
    private GitHubService service;

    @Mock
    private Result<SearchResult> result;

    @Mock
    private RetrofitRequest<SearchResult> request;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        when(request.call((Call<SearchResult>)any())).thenReturn(request);
    }

    @Test
    public void getRepositories_isCorrect() throws Exception {

        GitHubManager manager = new GitHubManager(service,  request);

        manager.getRepositories(1, result);

        verify(request).go(result);
    }
}