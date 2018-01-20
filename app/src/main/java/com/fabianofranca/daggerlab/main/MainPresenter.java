package com.fabianofranca.daggerlab.main;

import javax.inject.Inject;

public class MainPresenter implements MainPresenterContract {

    private String name;

    private MainViewContract view;

    @Inject
    public MainPresenter(MainViewContract view) {
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
