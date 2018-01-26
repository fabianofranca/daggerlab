package com.fabianofranca.daggerlab;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public abstract class BaseTest {

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    public String getStringFileContent(String file) throws Exception {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null ) {
            stringBuilder.append(line);
        }

        return  stringBuilder.toString();
    }
}