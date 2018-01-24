package com.fabianofranca.daggerlab.tools;

import com.fabianofranca.daggerlab.base.BaseTest;
import com.fabianofranca.daggerlab.tools.retrofit.RetrofitRequest;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import retrofit2.Call;
import retrofit2.Callback;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

public class RetrofitRequestTest extends BaseTest {

    @Mock
    private Call<String> call;

    @Mock
    private Result<String> result;

    @Test
    public void callSuccess_isCorrect() throws Exception {
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                result.success(null);
                return null;
            }
        }).when(call).enqueue(any(Callback.class));

        RetrofitRequest<String> request = new RetrofitRequest<>(call);

        request.call(result);

        verify(result).success(null);
    }

    @Test
    public void callFailure_isCorrect() throws Exception {
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                result.failure(null);
                return null;
            }
        }).when(call).enqueue(any(Callback.class));

        RetrofitRequest<String> request = new RetrofitRequest<>(call);

        request.call(result);

        verify(result).failure(null);
    }
}
