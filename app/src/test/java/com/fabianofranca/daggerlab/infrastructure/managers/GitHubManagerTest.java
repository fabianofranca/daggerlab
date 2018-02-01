package com.fabianofranca.daggerlab.infrastructure.managers;

import com.fabianofranca.daggerlab.BaseTest;
import com.fabianofranca.daggerlab.core.infrastructure.UIThreadFactory;
import com.fabianofranca.daggerlab.core.presentation.exceptions.ExceptionHandler;
import com.fabianofranca.daggerlab.infrastructure.services.GitHubService;
import com.fabianofranca.daggerlab.infrastructure.services.dto.SearchResult;
import com.fabianofranca.daggerlab.core.infrastructure.SuccessRequest;
import com.fabianofranca.daggerlab.core.infrastructure.retrofit.RetrofitRequest;

import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GitHubManagerTest extends BaseTest {

    @Mock
    private GitHubService service;

    @Mock
    private SuccessRequest<SearchResult> successRequest;

    @Mock
    private RetrofitRequest<SearchResult> request;

    @Mock
    private ExceptionHandler resolve;

    @Mock
    private UIThreadFactory uiThreadFactory;

    @Test
    public void getRepositories_isCorrect() throws Exception {

        GitHubManager manager = new GitHubManager(service, resolve, uiThreadFactory);

        when(service.searchRepositories(anyInt())).thenReturn(request);
        when(request.fail(any())).thenReturn(request);
        when(request.success(any())).thenReturn(request);

        manager.getRepositories(1, successRequest);

        verify(request).call();
    }
}