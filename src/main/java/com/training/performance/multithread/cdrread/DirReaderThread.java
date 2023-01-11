package com.training.performance.multithread.cdrread;

import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirReaderThread extends Thread {

    @Override
    public void run() {
        while (true) {
            try {
                Stream<Path> pathStream = Files.find(Paths.get("."),
                                                     1,
                                                     (s1, s2) -> true,
                                                     FileVisitOption.FOLLOW_LINKS);
                pathStream.forEach(p -> FileReaderThread.pathsForRead.add(p));
            } catch (Exception exceptionParam) {
                exceptionParam.printStackTrace();
            }
        }
    }
}
