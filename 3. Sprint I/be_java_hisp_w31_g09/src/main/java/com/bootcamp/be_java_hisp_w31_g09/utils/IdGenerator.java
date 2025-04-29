package com.bootcamp.be_java_hisp_w31_g09.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
    private static final AtomicInteger userCounter = new AtomicInteger(0);
    private static final AtomicInteger postCounter = new AtomicInteger(0);

    public static Integer getNextUserId() {
        return userCounter.incrementAndGet();
    }

    public static Integer getCurrentUserId() {
        return userCounter.get();
    }

    public static Integer getNextPostId() {
        return postCounter.incrementAndGet();
    }

    public static Integer getCurrentPostId() {
        return postCounter.get();
    }
}
