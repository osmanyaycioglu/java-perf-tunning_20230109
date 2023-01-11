package com.training.performance.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class PerfRun {

    public static long counter = 0;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        List<MyThread> myThreads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            MyThread thread = new MyThread(countDownLatch);
            myThreads.add(thread);
            thread.start();
        }
        long delta = System.nanoTime();
        countDownLatch.await();
        System.out.println("Delta : " + (System.nanoTime() - delta));

        long totalCounter = 0;
        for (MyThread myThread : myThreads) {
            totalCounter += myThread.getMyCounter();
        }

        System.out.println("Counter : " + counter);
        System.out.println("Total Counter : " + totalCounter);

        long counter = 0;
        for (long i = 0; i < 10; i++) {
            counter++;
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException eParam) {
//            }
        }
    }

}
