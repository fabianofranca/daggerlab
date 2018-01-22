package com.fabianofranca.daggerlab.tools;

import com.fabianofranca.daggerlab.base.BaseTest;
import com.fabianofranca.daggerlab.tools.retrofit.RetrofitRequest;

import org.junit.Test;
import org.mockito.Mock;

import retrofit2.Call;
import retrofit2.Callback;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class RetrofitRequestTest extends BaseTest {

    @Mock
    private Call<Object> call;

    @Mock
    private Result<Object> result;

    @Test
    public void call_isCorrect() throws Exception {

        RetrofitRequest<Object> request = new RetrofitRequest<>();

        RetrofitRequest<Object> requestReturn = request.call(call);

        assertEquals(request, requestReturn);
    }

    @Test
    public void go_isCorrect() throws Exception {
        RetrofitRequest<Object> request = new RetrofitRequest<>();

        request.call(call);
        request.go(result);

        verify(call).enqueue((Callback<Object>)any());

        //TODO: Terminar teste e verificando as chamadas ao result
    }
}
