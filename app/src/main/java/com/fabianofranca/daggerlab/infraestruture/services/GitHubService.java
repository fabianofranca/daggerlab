package com.fabianofranca.daggerlab.infraestruture.services;

import com.fabianofranca.daggerlab.infraestruture.core.Request;
import com.fabianofranca.daggerlab.infraestruture.services.dto.SearchResult;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GitHubService {

    @GET("search/repositories?q=license:mit&sort=stars")
    Request<SearchResult> searchRepositories(@Query("page") int page);
}
