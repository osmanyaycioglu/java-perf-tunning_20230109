package com.training.performance.multithread.cdrread;

public class CdrRun {
    public static void main(String[] args) {
        DirReaderThread dirReaderThread = new DirReaderThread();
        dirReaderThread.run();
        for (int i = 0; i < 4; i++) {
            FileReaderThread fileReaderThread = new FileReaderThread();
            fileReaderThread.start();
        }
        for (int i = 0; i < 32; i++) {
            ProcessThread processThread = new ProcessThread();
            processThread.start();
        }
    }
}
