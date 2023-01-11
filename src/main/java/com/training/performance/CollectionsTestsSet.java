package com.training.performance;

import java.security.SecureRandom;
import java.util.*;

public class CollectionsTestsSet {

    public static void main(String[] args) {
        Set<String> strWarmup = new LinkedHashSet<>();
        for (int i = 0; i < 1_000_000; i++) {
            strWarmup.add("test" + i);
        }

        System.gc();

        try {
            Thread.sleep(2_000);
        } catch (InterruptedException eParam) {
        }

        Set<String> strings = new LinkedHashSet<>();
        long delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            strings.add("test" + i);
        }
        System.out.println("add Delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            boolean contains = strings.contains("test" + i);
        }
        System.out.println("contains Delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (String string : strings) {
            String str = string;
        }
        System.out.println("Iterate Delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++) {
            strings.remove("test" + i);
        }
        System.out.println("Remove Delta : " + (System.currentTimeMillis() - delta));

        delta = System.nanoTime();
        // strWarmup.contains("test1");
        //strWarmup.containsAll(Arrays.asList("test1","test2"));
        //strWarmup.removeAll(Arrays.asList("test1","test2"));
        strWarmup.retainAll(Arrays.asList("test1","test2"));
        System.out.println("Contains Delta : " + (System.nanoTime() - delta));

    }

}
