package com.fabianofranca.daggerlab.di.module.infraestruture.manager;

import com.fabianofranca.daggerlab.domain.repositories.GitHubRepository;
import com.fabianofranca.daggerlab.infraestruture.manager.GitHubManager;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class GitHubManagerModule {

    @Binds
    @Singleton
    abstract GitHubRepository bindGitHubRepository(GitHubManager manager);
}