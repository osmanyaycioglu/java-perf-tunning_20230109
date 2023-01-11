package com.training.performance;

import java.security.SecureRandom;
import java.util.*;

public class CollectionsTestsList {

    public static void main(String[] args) {
        Random random = new SecureRandom(UUID.randomUUID()
                                             .toString()
                                             .getBytes());
        List<String> strWarmup = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            strWarmup.add("test");
        }

        System.gc();

        try {
            Thread.sleep(2_000);
        } catch (InterruptedException eParam) {
        }

        List<String> strings = new ArrayList<>();
        long delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            strings.add("test");
        }
        System.out.println("List add Delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++) {
            strings.get(i);
        }
        System.out.println("Index get Delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (String string : strings) {
            String str = string;
        }
        System.out.println("Iterate Delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++) {
            strings.remove(1);
        }
        System.out.println("Remove Delta : " + (System.currentTimeMillis() - delta));

        //        strings.add("random : " + random.nextInt());
        //        strings.remove(1);

        // Listelerde bunları kullanma
        delta = System.nanoTime();
        // strWarmup.contains("test1");
        // strWarmup.removeAll(Arrays.asList("test1","test2"));
        // strWarmup.retainAll(Arrays.asList("test1","test2"));
        strWarmup.containsAll(Arrays.asList("test1","test2"));
        System.out.println("Contains Delta : " + (System.nanoTime() - delta));

    }

}
