package com.training.performance.multithread.cdrread;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Stream;

public class ProcessThread extends Thread {

    public static BlockingQueue<String> lines = new ArrayBlockingQueue<>(100_000);
    private long counter = 0;
    @Override
    public void run() {
        while (true) {
            try {
                String take = lines.take();
                counter++;
                String[] split = take.split(",");
                // transform to CDR
                // send to CyclicBuffer
                if (counter % 10_000 == 0){
                    Thread.sleep(1);
                }
            } catch (Exception exceptionParam) {
                exceptionParam.printStackTrace();
            }
        }
    }
}
