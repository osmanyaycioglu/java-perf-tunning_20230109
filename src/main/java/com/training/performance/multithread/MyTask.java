package com.training.performance.multithread;

public class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println("çalıştım");
    }
}
