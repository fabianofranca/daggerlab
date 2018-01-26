package com.fabianofranca.daggerlab.presentation.main;

import com.fabianofranca.daggerlab.domain.repositories.GitHubRepository;
import com.fabianofranca.daggerlab.infraestruture.services.core.Result;
import com.fabianofranca.daggerlab.infraestruture.services.dto.SearchResult;

import javax.inject.Inject;

public class MainPresenter implements MainContract.Presenter {

    private String name;

    private MainContract.View view;

    private GitHubRepository repository;

    @Inject
    public MainPresenter(MainContract.View view, GitHubRepository repository) {
        this.view = view;
        this.repository = repository;

        //TODO Criar RecyclerView e reescrever essa chamada da maneira correta
        repository.getRepositories(1, new Result<SearchResult>() {
            @Override
            public void success(SearchResult data) {

            }

            @Override
            public void failure(Throwable throwable) {

            }
        });
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
