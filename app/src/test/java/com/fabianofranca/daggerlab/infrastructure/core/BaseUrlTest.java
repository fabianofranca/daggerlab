package com.fabianofranca.daggerlab.infrastructure.core;

import com.fabianofranca.daggerlab.core.infrastructure.BaseUrl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BaseUrlTest {
    @Test
    public void getUrl_isCorrect() throws Exception {
        BaseUrl baseUrl = new BaseUrl("teste");

        assertEquals("teste", baseUrl.getUrl());
    }
}
