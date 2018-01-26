package com.fabianofranca.daggerlab.presentation.main;

import com.fabianofranca.daggerlab.domain.repositories.GitHubRepository;
import com.fabianofranca.daggerlab.infraestruture.services.core.Result;
import com.fabianofranca.daggerlab.infraestruture.services.dto.SearchResult;

import javax.inject.Inject;

public class MainPresenter implements MainContract.Presenter, Result<SearchResult> {

    private MainContract.View view;

    private GitHubRepository repository;

    @Inject
    public MainPresenter(MainContract.View view, GitHubRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void refreshRepoList(int page) {
        view.showLoading();
        repository.getRepositories(page, this);
    }

    @Override
    public void success(SearchResult data) {
        view.updateRepoList(data.getRepositories());
        view.hideLoading();
    }

    @Override
    public void failure(Throwable throwable) {
        view.hideLoading();
    }
}