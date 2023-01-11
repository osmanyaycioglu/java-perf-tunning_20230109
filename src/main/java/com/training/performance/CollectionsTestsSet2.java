package com.training.performance;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CollectionsTestsSet2 {

    public static void main(String[] args) {
        Set<String> group1 = new HashSet<>(Arrays.asList("1","2","3","4","5"));
        Set<String> group2 = new HashSet<>(Arrays.asList("3","4","5","6","7 "));

        group1.addAll(group2);

        System.out.println(group1);

    }

}
