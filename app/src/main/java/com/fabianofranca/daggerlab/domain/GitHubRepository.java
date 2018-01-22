package com.fabianofranca.daggerlab.domain;

import com.fabianofranca.daggerlab.infraestruture.services.dto.SearchResult;
import com.fabianofranca.daggerlab.tools.Result;

public interface GitHubRepository {

    void getRepositories(int page, Result<SearchResult> result);
}