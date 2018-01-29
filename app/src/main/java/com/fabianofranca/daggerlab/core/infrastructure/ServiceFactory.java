package com.fabianofranca.daggerlab.core.infrastructure;

public interface ServiceFactory<T> {
     T createService(BaseUrl baseUrl, Class<T> service);
}