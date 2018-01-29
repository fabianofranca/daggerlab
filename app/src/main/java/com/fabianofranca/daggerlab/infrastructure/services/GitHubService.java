package com.fabianofranca.daggerlab.infrastructure.services;

import com.fabianofranca.daggerlab.core.infrastructure.Request;
import com.fabianofranca.daggerlab.infrastructure.services.dto.SearchResult;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GitHubService {

    @GET("search/repositories?q=license:mit&sort=stars")
    Request<SearchResult> searchRepositories(@Query("page") int page);
}
