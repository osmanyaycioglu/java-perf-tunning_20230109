package com.training.performance.multithread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "yaptım bitti";
    }

}
