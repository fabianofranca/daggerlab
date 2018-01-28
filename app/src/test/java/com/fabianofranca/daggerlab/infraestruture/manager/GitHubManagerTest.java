package com.fabianofranca.daggerlab.infraestruture.manager;

import com.fabianofranca.daggerlab.BaseTest;
import com.fabianofranca.daggerlab.infraestruture.services.GitHubService;
import com.fabianofranca.daggerlab.infraestruture.services.dto.SearchResult;
import com.fabianofranca.daggerlab.infraestruture.core.RequestResult;
import com.fabianofranca.daggerlab.infraestruture.core.retrofit.RetrofitRequest;

import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GitHubManagerTest extends BaseTest {

    @Mock
    private GitHubService service;

    @Mock
    private RequestResult<SearchResult> requestResult;

    @Mock
    private RetrofitRequest<SearchResult> request;

    @Test
    public void getRepositories_isCorrect() throws Exception {

        GitHubManager manager = new GitHubManager(service);

        when(service.searchRepositories(anyInt())).thenReturn(request);

        manager.getRepositories(1, requestResult);

        verify(request).call(requestResult);
    }
}