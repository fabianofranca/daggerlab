package com.fabianofranca.daggerlab.domain;

import com.fabianofranca.daggerlab.infraestruture.services.BaseUrl;

public interface ServiceFactory {
    <T> T createService(Class<T> service, BaseUrl baseUrl);
}