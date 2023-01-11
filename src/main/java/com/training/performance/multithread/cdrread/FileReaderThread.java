package com.training.performance.multithread.cdrread;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Stream;

public class FileReaderThread extends Thread {

    public static BlockingQueue<Path> pathsForRead = new ArrayBlockingQueue<>(10_000);

    @Override
    public void run() {
        while (true){
            try {
                Path take = pathsForRead.take();
                List<String> strings = Files.readAllLines(take);
                strings.forEach(l -> ProcessThread.lines.add(l));
            } catch (Exception exceptionParam){
                exceptionParam.printStackTrace();
            }
        }
    }
}
