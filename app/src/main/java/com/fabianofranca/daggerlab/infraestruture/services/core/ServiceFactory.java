package com.fabianofranca.daggerlab.infraestruture.services.core;

public interface ServiceFactory<T> {
     T createService(BaseUrl baseUrl, Class<T> service);
}