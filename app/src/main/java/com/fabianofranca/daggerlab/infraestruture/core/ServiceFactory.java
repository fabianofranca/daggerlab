package com.fabianofranca.daggerlab.infraestruture.core;

public interface ServiceFactory<T> {
     T createService(BaseUrl baseUrl, Class<T> service);
}