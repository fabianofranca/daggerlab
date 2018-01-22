package com.fabianofranca.daggerlab.infraestruture.manager;

import com.fabianofranca.daggerlab.infraestruture.manager.GitHub.GitHubManager;
import com.fabianofranca.daggerlab.infraestruture.services.GitHubServiceMock;
import com.fabianofranca.daggerlab.infraestruture.services.base.GitHubServiceBaseTest;
import com.fabianofranca.daggerlab.infraestruture.services.dto.SearchResult;
import com.fabianofranca.daggerlab.tools.Result;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

public class GitHubManagerTest extends GitHubServiceBaseTest {

    @Mock
    private Result<SearchResult> result;

    private final CountDownLatch signal = new CountDownLatch(1);

    @Override
    public void setUp() throws Exception {
        super.setUp();

        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                signal.countDown();
                return null;
            }
        }).when(result).success(any(SearchResult.class));
    }

    @Test
    public void getRepositories_isCorrect() throws Exception {
        GitHubServiceMock.setupGetRepositoriesSuccessMock(this);

        GitHubManager manager = new GitHubManager(getService());

        manager.getRepositories(1, result);

        signal.await();

        verify(result).success(any(SearchResult.class));
    }
}