package com.fabianofranca.daggerlab.infraestruture.services.dto;

import com.fabianofranca.daggerlab.domain.entity.Repo;

import java.util.List;

public class SearchResult {
    private List<Repo> items;

    public List<Repo> getRepositories() {
        return items;
    }
}