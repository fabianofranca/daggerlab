package com.fabianofranca.daggerlab.presentation.main;

import com.fabianofranca.daggerlab.domain.GitHubRepository;
import com.fabianofranca.daggerlab.infraestruture.services.dto.SearchResult;
import com.fabianofranca.daggerlab.tools.Result;

import javax.inject.Inject;

public class MainPresenter implements MainContract.Presenter {

    private String name;

    private MainContract.View view;

    private GitHubRepository repository;

    @Inject
    public MainPresenter(MainContract.View view, GitHubRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void showName() {
        view.showToast(name);
    }
}
