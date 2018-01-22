package com.fabianofranca.daggerlab.infraestruture.services.dto;

import com.fabianofranca.daggerlab.domain.models.Repo;

import java.util.List;

public class SearchResult {
    private List<Repo> items;

    public List<Repo> getRepositories() {
        return items;
    }
}