package com.fabianofranca.daggerlab.dagger.module.infraestruture.manager;

import com.fabianofranca.daggerlab.dagger.scope.RequestScope;
import com.fabianofranca.daggerlab.domain.GitHubRepository;
import com.fabianofranca.daggerlab.infraestruture.manager.GitHub.GitHubManager;
import com.fabianofranca.daggerlab.infraestruture.services.dto.SearchResult;
import com.fabianofranca.daggerlab.tools.BaseRequest;
import com.fabianofranca.daggerlab.tools.Result;
import com.fabianofranca.daggerlab.tools.retrofit.RetrofitRequest;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class GitHubManagerModule {

    @Binds
    @Singleton
    abstract GitHubRepository bindGitHubRepository(GitHubManager manager);

    @Binds
    @RequestScope
    abstract BaseRequest<SearchResult> bindSearhResulRequest(RetrofitRequest<SearchResult> request);
}