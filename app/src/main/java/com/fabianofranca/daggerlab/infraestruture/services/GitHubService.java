package com.fabianofranca.daggerlab.infraestruture.services;

import com.fabianofranca.daggerlab.infraestruture.services.dto.SearchResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GitHubService {

    @GET("search/repositories?q=license:mit&sort=stars")
    Call<SearchResult> searchRepositories(@Query("page") int page);
}
