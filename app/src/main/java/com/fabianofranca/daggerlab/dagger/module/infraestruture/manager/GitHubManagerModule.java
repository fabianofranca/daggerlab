package com.fabianofranca.daggerlab.dagger.module.infraestruture.manager;

import com.fabianofranca.daggerlab.domain.GitHubRepository;
import com.fabianofranca.daggerlab.infraestruture.manager.GitHub.GitHubManager;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class GitHubManagerModule {

    @Binds
    @Singleton
    abstract GitHubRepository bindGitHubRepository(GitHubManager manager);
}