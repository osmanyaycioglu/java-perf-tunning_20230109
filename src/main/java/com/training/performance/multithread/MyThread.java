package com.training.performance.multithread;

import lombok.Getter;

import java.util.concurrent.CountDownLatch;

public class MyThread extends Thread {

    private CountDownLatch countDownLatch;
    @Getter
    private long           myCounter = 0;

    public MyThread(CountDownLatch countDownLatchParam) {
        countDownLatch = countDownLatchParam;
    }

    public static synchronized void increase() {
        PerfRun.counter++;

    }

    @Override
    public void run() {
        for (int i = 0; i < 10_000_000; i++) {
            // PerfRun.counter++;
            // increase();
            myCounter++;
        }
        countDownLatch.countDown();
    }

}
