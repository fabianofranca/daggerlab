package com.fabianofranca.daggerlab.domain.repositories;

import com.fabianofranca.daggerlab.infraestruture.core.RequestResult;
import com.fabianofranca.daggerlab.infraestruture.services.dto.SearchResult;

public interface GitHubRepository {

    void getRepositories(int page, RequestResult<SearchResult> requestResult);
}