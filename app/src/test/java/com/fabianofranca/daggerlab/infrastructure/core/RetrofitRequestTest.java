package com.fabianofranca.daggerlab.infrastructure.core;

import com.fabianofranca.daggerlab.BaseTest;
import com.fabianofranca.daggerlab.core.infrastructure.FailureRequest;
import com.fabianofranca.daggerlab.core.infrastructure.SuccessRequest;
import com.fabianofranca.daggerlab.core.infrastructure.retrofit.RetrofitRequest;
import com.fabianofranca.daggerlab.core.presentation.exceptions.NetworkException;
import com.fabianofranca.daggerlab.core.presentation.exceptions.RequestException;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RetrofitRequestTest extends BaseTest {

    @Mock
    private Call<String> call;

    @Mock
    private SuccessRequest<String> successRequest;

    @Mock
    private FailureRequest failureRequest;

    @Mock
    private ResponseBody responseBody;

    @Test
    public void call_IsCorrect() throws Exception {
        RetrofitRequest<String> request = new RetrofitRequest<>(call);

        request
            .success(successRequest)
            .call();

        verify(call).enqueue(request);
    }

    @Test
    public void execute_IsCorrect() throws Exception {
        RetrofitRequest<String> request = new RetrofitRequest<>(call);

        String body = "body";

        Response<String> response = Response.success(body);

        when(call.execute()).thenReturn(response);

        String result = request.execute();

        assertEquals(body, result);
    }

    @Test
    public void onResponse_SuccessfulIsCorrect() throws Exception {

        RetrofitRequest<String> request = new RetrofitRequest<>(call);

        request.success(successRequest);

        String body = "body";

        Response<String> response = Response.success(body);

        request.onResponse(call, response);

        verify(successRequest).success(body);
    }

    @Test
    public void onResponse_UnsuccessfulIsCorrect() throws Exception {
        RetrofitRequest<String> request = new RetrofitRequest<>(call);

        request.fail(failureRequest);

        int code = 500;

        Response<String> response = Response.error(code, responseBody);

        String message = response.message();

        request.onResponse(call, response);

        ArgumentCaptor<RequestException> captor = ArgumentCaptor.forClass(RequestException.class);

        verify(failureRequest).fail(captor.capture());

        RequestException requestException = captor.getValue();
        assertEquals(code, requestException.getCode());
        assertEquals(message, requestException.getMessage());
    }

    @Test
    public void onFailure_IsCorrect() throws Exception {
        RetrofitRequest<String> request = new RetrofitRequest<>(call);

        request.fail(failureRequest);

        Exception exception = new Exception();
        request.onFailure(call, exception);

        ArgumentCaptor<Throwable> captor = ArgumentCaptor.forClass(Throwable.class);

        verify(failureRequest).fail(captor.capture());

        Throwable throwable = captor.getValue();
        assertTrue(throwable instanceof NetworkException);
        assertEquals(exception, throwable.getCause());
    }
}