package com.fabianofranca.daggerlab.main;

import javax.inject.Inject;

public class MainPresenter implements MainContract.Presenter {

    private String name;

    private MainContract.View view;

    @Inject
    public MainPresenter(MainContract.View view) {
        this.view = view;
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
