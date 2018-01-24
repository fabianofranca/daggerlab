package com.fabianofranca.daggerlab.infraestruture.manager.GitHub;

import com.fabianofranca.daggerlab.domain.GitHubRepository;
import com.fabianofranca.daggerlab.infraestruture.services.GitHubService;
import com.fabianofranca.daggerlab.infraestruture.services.dto.SearchResult;
import com.fabianofranca.daggerlab.tools.Result;

import javax.inject.Inject;

public class GitHubManager implements GitHubRepository {

    private GitHubService service;

    @Inject
    public GitHubManager(GitHubService service) {
        this.service = service;
    }

    @Override
    public void getRepositories(final int page, Result<SearchResult> result) {
        service.searchRepositories(page).call(result);
    }
}