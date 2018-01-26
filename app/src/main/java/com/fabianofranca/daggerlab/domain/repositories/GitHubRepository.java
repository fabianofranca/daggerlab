package com.fabianofranca.daggerlab.domain.repositories;

import com.fabianofranca.daggerlab.infraestruture.services.core.Result;
import com.fabianofranca.daggerlab.infraestruture.services.dto.SearchResult;

public interface GitHubRepository {

    void getRepositories(int page, Result<SearchResult> result);
}