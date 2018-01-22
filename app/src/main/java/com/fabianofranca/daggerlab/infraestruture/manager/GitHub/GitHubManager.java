package com.fabianofranca.daggerlab.infraestruture.manager.GitHub;

import com.fabianofranca.daggerlab.domain.GitHubRepository;
import com.fabianofranca.daggerlab.infraestruture.services.GitHubService;
import com.fabianofranca.daggerlab.infraestruture.services.dto.SearchResult;
import com.fabianofranca.daggerlab.tools.Result;
import com.fabianofranca.daggerlab.tools.retrofit.RetrofitRequest;

import javax.inject.Inject;

public class GitHubManager implements GitHubRepository {

    private GitHubService service;
    private RetrofitRequest<SearchResult> request;

    @Inject
    public GitHubManager(GitHubService service, RetrofitRequest<SearchResult> request) {
        this.service = service;
        this.request = request;
    }

    @Override
    public void getRepositories(final int page, Result<SearchResult> result) {
        request.call(service.searchRepositories(page))
                .go(result);
    }
}