package com.fabianofranca.daggerlab.presentation.main;

public interface MainContract {

    interface View {
        void showToast(String text);
    }

    interface Presenter {
        void setName(String name);
        void showName();
    }
}
