package com.fabianofranca.daggerlab.infrastructure.core;

import com.fabianofranca.daggerlab.BaseTest;
import com.fabianofranca.daggerlab.core.infrastructure.RequestResult;
import com.fabianofranca.daggerlab.core.infrastructure.retrofit.RetrofitRequest;
import com.fabianofranca.daggerlab.core.presentation.exceptions.ExceptionResolve;

import org.junit.Test;
import org.mockito.Mock;

import retrofit2.Call;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

public class RetrofitRequestTest extends BaseTest {

    @Mock
    private Call<String> call;

    @Mock
    private RequestResult<String> requestResult;

    @Mock
    private ExceptionResolve exceptionResolve;

    @Test
    public void callSuccess_isCorrect() throws Exception {
        doAnswer((invocation) -> {
            requestResult.success(null);
            return null;
        }).when(call).enqueue(any());

        RetrofitRequest<String> request = new RetrofitRequest<>(call, exceptionResolve);

        request.call(requestResult);

        verify(requestResult).success(null);
    }
}
