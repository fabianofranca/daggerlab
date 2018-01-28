package com.fabianofranca.daggerlab.infraestruture.manager;

import com.fabianofranca.daggerlab.domain.repositories.GitHubRepository;
import com.fabianofranca.daggerlab.infraestruture.services.GitHubService;
import com.fabianofranca.daggerlab.infraestruture.services.dto.SearchResult;
import com.fabianofranca.daggerlab.infraestruture.core.RequestResult;

import javax.inject.Inject;

public class GitHubManager implements GitHubRepository {

    private GitHubService service;

    @Inject
    public GitHubManager(GitHubService service) {
        this.service = service;
    }

    @Override
    public void getRepositories(final int page, RequestResult<SearchResult> requestResult) {
        service.searchRepositories(page).call(requestResult);
    }
}