package com.fabianofranca.daggerlab.infrastructure.services.dto;

import com.fabianofranca.daggerlab.domain.entities.Repo;

import java.util.List;

public class SearchResult {
    private List<Repo> items;

    public List<Repo> getRepositories() {
        return items;
    }
}