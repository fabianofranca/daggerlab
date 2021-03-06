package com.fabianofranca.daggerlab.di.module.presentation;

import android.support.v7.widget.RecyclerView;

import com.fabianofranca.daggerlab.presentation.main.MainActivity;
import com.fabianofranca.daggerlab.presentation.main.MainContract;
import com.fabianofranca.daggerlab.presentation.main.MainPresenter;
import com.fabianofranca.daggerlab.presentation.main.RepoAdapter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MainModule {

    @Binds
    abstract MainContract.Presenter bindPresenter(MainPresenter presenter);

    @Binds
    abstract MainContract.View bindView(MainActivity mainActivity);

    @Binds
    abstract RecyclerView.Adapter<RepoAdapter.ViewHolder> bindRepoAdapter(RepoAdapter adapter);
}