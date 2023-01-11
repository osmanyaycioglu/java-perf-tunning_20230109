package com.training.performance;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionsTestsMap {

    public static void main(String[] args) {
        Map<String, String> strWarmup = new ConcurrentHashMap<>(1_200_000,
                                                                0.9f,
                                                                1_000);
        for (int i = 0; i < 1_000_000; i++) {
            strWarmup.put("test" + i,
                          "test" + i);
        }

        System.gc();

        try {
            Thread.sleep(2_000);
        } catch (InterruptedException eParam) {
        }

        Map<String, String> strings = new ConcurrentHashMap<>(1_200_000,
                                                              0.9f,
                                                              1_000);
        long delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            strings.put("test" + i,
                        "test" + i);
        }
        System.out.println("add Delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            boolean contains = strings.containsKey("test" + i);
        }
        System.out.println("contains Delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (String string : strings.values()) {
            String str = string;
        }
        System.out.println("Iterate Delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++) {
            strings.remove("test" + i);
        }
        System.out.println("Remove Delta : " + (System.currentTimeMillis() - delta));

        delta = System.nanoTime();
        strWarmup.containsKey("test1");
        //strWarmup.containsAll(Arrays.asList("test1","test2"));
        //strWarmup.removeAll(Arrays.asList("test1","test2"));
        // strWarmup.retainAll(Arrays.asList("test1","test2"));
        System.out.println("Contains Delta : " + (System.nanoTime() - delta));

    }

}
