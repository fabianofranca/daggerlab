package com.fabianofranca.daggerlab.di.module.presentation;

import android.support.v7.widget.RecyclerView;

import com.fabianofranca.daggerlab.di.scope.ActivityScope;
import com.fabianofranca.daggerlab.presentation.main.MainActivity;
import com.fabianofranca.daggerlab.presentation.main.MainContract;
import com.fabianofranca.daggerlab.presentation.main.MainPresenter;
import com.fabianofranca.daggerlab.presentation.main.RepoAdapter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MainModule {

    @Binds
    @ActivityScope
    abstract MainContract.Presenter bindPresenter(MainPresenter presenter);

    @Binds
    @ActivityScope
    abstract MainContract.View bindView(MainActivity mainActivity);

    @Binds
    @ActivityScope
    abstract RecyclerView.Adapter<RepoAdapter.ViewHolder> bindRepoAdapter(RepoAdapter adapter);
}