package com.mercadolibre.melifrescosg9w31.unit.config;

import com.mercadolibre.melifrescosg9w31.config.ExecutorConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@TestPropertySource(properties = {
        "async.executor.pool-size=5",
        "async.executor.prefix=test-async-",
        "async.executor.await-termination=30",
        "scheduler.executor.pool-size=2",
        "scheduler.executor.prefix=test-scheduler-"
})
@Configuration
@Import(ExecutorConfig.class)
class ExecutorConfigTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void testGetAsyncUncaughtExceptionHandler() {
        ExecutorConfig executorConfig = applicationContext.getBean(ExecutorConfig.class);
        AsyncUncaughtExceptionHandler handler = executorConfig.getAsyncUncaughtExceptionHandler();
        assertNotNull(handler);
        assertInstanceOf(SimpleAsyncUncaughtExceptionHandler.class, handler);
    }

    @Test
    void testConfigureTasksRegistersScheduler() {
        ExecutorConfig executorConfig = applicationContext.getBean(ExecutorConfig.class);
        org.springframework.scheduling.config.ScheduledTaskRegistrar mockTaskRegistrar = mock(org.springframework.scheduling.config.ScheduledTaskRegistrar.class);

        executorConfig.configureTasks(mockTaskRegistrar);

        verify(mockTaskRegistrar, times(1)).setScheduler(any(org.springframework.scheduling.TaskScheduler.class));
    }

    private ThreadPoolExecutor getInternalExecutor(ExecutorService meliExecutor) {
        // This is a bit of a hack to get the underlying ThreadPoolExecutor
        // from the MeliExecutors.trace() wrapper for assertion purposes.
        // In a real scenario, you might rely more on the behavior than the internal structure.
        try {
            java.lang.reflect.Field field = meliExecutor.getClass().getDeclaredField("delegate");
            field.setAccessible(true);
            Object delegate = field.get(meliExecutor);
            if (delegate instanceof ThreadPoolExecutor) {
                return (ThreadPoolExecutor) delegate;
            } else if (delegate instanceof ThreadPoolTaskExecutor) {
                return ((ThreadPoolTaskExecutor) delegate).getThreadPoolExecutor();
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to get internal executor for testing: " + e.getMessage());
        }
        return null;
    }
}