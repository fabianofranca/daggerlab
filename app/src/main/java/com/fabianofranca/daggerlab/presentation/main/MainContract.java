package com.fabianofranca.daggerlab.presentation.main;

import com.fabianofranca.daggerlab.domain.entities.Repo;

import java.util.List;

public interface MainContract {

    interface View {
        void updateRepoList(List<Repo> repos);
        void showLoading();
        void hideLoading();
    }

    interface Presenter {
        void refreshRepoList(int page);
    }
}