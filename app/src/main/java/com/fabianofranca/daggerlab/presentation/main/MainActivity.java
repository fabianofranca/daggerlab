package com.fabianofranca.daggerlab.presentation.main;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fabianofranca.daggerlab.R;
import com.fabianofranca.daggerlab.domain.entities.Repo;
import com.fabianofranca.daggerlab.core.presentation.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainContract.View {

    @Inject
    MainContract.Presenter presenter;

    @Inject
    RepoAdapter adapter;

    @BindView(R.id.recycler_repo)
    RecyclerView recycler;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);

        presenter.refreshRepoList(0);
    }

    @Override
    public void updateRepoList(final List<Repo> repos) {
        adapter.refreshData(repos);
    }

    @Override
    public void showLoading() {
        progressDialog = new ProgressDialog(this);
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();
    }
}