package com.fabianofranca.daggerlab.infraestruture.core;

import com.fabianofranca.daggerlab.BaseTest;
import com.fabianofranca.daggerlab.infraestruture.core.retrofit.RetrofitRequest;

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

    @Test
    public void callSuccess_isCorrect() throws Exception {
        doAnswer((invocation) -> {
            requestResult.success(null);
            return null;
        }).when(call).enqueue(any());

        RetrofitRequest<String> request = new RetrofitRequest<>(call);

        request.call(requestResult);

        verify(requestResult).success(null);
    }
}
