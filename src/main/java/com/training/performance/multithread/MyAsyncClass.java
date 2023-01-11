package com.training.performance.multithread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Component
public class MyAsyncClass {

    @Async("myExecutor")
    public Future<String> doSome(String str) {
        System.out.println("started " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException eParam) {

        }
        System.out.println("I am doing something " + Thread.currentThread().getName());
        // ... code
        return CompletableFuture.completedFuture("I did it");
    }

}
