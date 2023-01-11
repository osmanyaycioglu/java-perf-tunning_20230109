package com.training.performance.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloRestController {

    private Map<String, String>    stringStringMap = new ConcurrentHashMap<>(10_000,
                                                                             0.9f,
                                                                             100);
    private List<String>           stringLis       = Collections.synchronizedList(new ArrayList<>());
    private AtomicInteger          count           = new AtomicInteger();
    private ReentrantLock          reentrantLock   = new ReentrantLock();
    private ReentrantReadWriteLock readWriteLock   = new ReentrantReadWriteLock();

    private       int    counter2    = 0;
    private       int    counter3    = 0;
    private final Object counterLock = new Object();

    public void increase() {
        System.out.println("test");
        synchronized (this) {
            counter2++;
        }
    }

    public void increase2() {
        synchronized (counterLock) {
            System.out.println("test");
            counter2++;
        }
    }

    public void increase3() {
        System.out.println("test");
        reentrantLock.lock();
        try {
            counter2++;
        } finally {
            reentrantLock.unlock();
        }

    }

    public void increase4() {
        System.out.println("test");
        readWriteLock.writeLock()
                     .lock();
        try {
            counter2++;
        } finally {
            readWriteLock.writeLock()
                         .unlock();
        }
    }

    public int getCounter4() {
        readWriteLock.readLock()
                     .lock();
        try {
            return counter2;
        } finally {
            readWriteLock.readLock()
                         .unlock();
        }
    }

    @GetMapping("/helloworld")
    public String helloWorld() {
        stringLis.add("hello" + count.incrementAndGet());
        return "Hello world - " + Thread.currentThread()
                                        .getName();
    }

}
