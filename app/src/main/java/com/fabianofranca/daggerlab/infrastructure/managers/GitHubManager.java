package com.fabianofranca.daggerlab.infrastructure.managers;

import com.fabianofranca.daggerlab.core.infrastructure.SuccessRequest;
import com.fabianofranca.daggerlab.core.infrastructure.UIThreadFactory;
import com.fabianofranca.daggerlab.core.presentation.exceptions.ExceptionHandler;
import com.fabianofranca.daggerlab.domain.repositories.GitHubRepository;
import com.fabianofranca.daggerlab.infrastructure.services.GitHubService;
import com.fabianofranca.daggerlab.infrastructure.services.dto.SearchResult;

import javax.inject.Inject;

public class GitHubManager implements GitHubRepository {

    private GitHubService service;
    private ExceptionHandler exceptionHandler;
    private UIThreadFactory uiThreadFactory;

    @Inject
    public GitHubManager(GitHubService service, ExceptionHandler exceptionHandler,
                         UIThreadFactory uiThreadFactory) {

        this.uiThreadFactory = uiThreadFactory;
        this.service = service;
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    public void getRepositories(final int page, SuccessRequest<SearchResult> successRequest) {
        service.searchRepositories(page)
                .success(uiThreadFactory.getSuccessRequest(successRequest))
                .fail(uiThreadFactory.getFailureRequest(t -> exceptionHandler.handling(t)))
                .call();
    }
}