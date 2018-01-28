package com.fabianofranca.daggerlab.presentation.main;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fabianofranca.daggerlab.R;
import com.fabianofranca.daggerlab.domain.entity.Repo;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.ViewHolder> {

    private List<Repo> repos = Arrays.asList();

    @Inject
    public RepoAdapter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ConstraintLayout view = (ConstraintLayout) LayoutInflater
                .from(parent.getContext()).inflate(R.layout.repo_view_holder, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(repos.get(position));
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    public void refreshData(List<Repo> repos) {
        this.repos = repos;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ConstraintLayout view;

        @BindView(R.id.repo_name)
        TextView repoName;

        public ViewHolder(ConstraintLayout view) {
            super(view);
            this.view = view;

            ButterKnife.bind(this, this.view);
        }

        public void bind(Repo repo) {
            repoName.setText(repo.getName());
        }
    }
}