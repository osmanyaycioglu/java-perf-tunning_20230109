package com.training.performance.multithread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    private MyAsyncClass myAsyncClass;

    @Autowired
    @Qualifier("myExecutor")
    private ExecutorService executor;

    @Override
    public void run(String... args) throws Exception {
        executor.execute(new MyTask());
        Future<String> submit = executor.submit(new MyCallable());
        submit.isDone();
        String s1 = submit.get();

        // Async example
        Future<String> test = myAsyncClass.doSome("test");
        System.out.println("my op 1 "  + Thread.currentThread().getName());
        System.out.println("my op 2 " + Thread.currentThread().getName());
        String s = test.get();
    }
}
