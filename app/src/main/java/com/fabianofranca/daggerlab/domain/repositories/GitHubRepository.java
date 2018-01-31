package com.fabianofranca.daggerlab.domain.repositories;

import com.fabianofranca.daggerlab.core.infrastructure.SuccessRequest;
import com.fabianofranca.daggerlab.infrastructure.services.dto.SearchResult;

public interface GitHubRepository {

    void getRepositories(int page, SuccessRequest<SearchResult> successRequest);
}