package com.fabianofranca.daggerlab.infraestruture.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BaseUrlTest {
    @Test
    public void getUrl_isCorrect() throws Exception {
        BaseUrl baseUrl = new BaseUrl("teste");

        assertEquals("teste", baseUrl.getUrl());
    }
}
