package com.fabianofranca.daggerlab.presentation.main;

import com.fabianofranca.daggerlab.domain.repositories.GitHubRepository;

import javax.inject.Inject;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;

    private GitHubRepository repository;

    @Inject
    public MainPresenter(MainContract.View view, GitHubRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void refreshRepoList(int page) {
        //view.showLoading();

        repository.getRepositories(page, (data) -> {
            view.updateRepoList(data.getRepositories());
            //view.hideLoading();
        });
    }
}