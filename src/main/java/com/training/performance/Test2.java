package com.training.performance;

import java.util.function.Supplier;

public class Test2 {


    public static void main(String[] args) {

        int counter = 0;
        for (int i = 0; i < 1_000_000; i++) {
            method1("test " + counter + " i : " + i);
        }

        System.gc();

        try {
            Thread.sleep(2_000);
        } catch (InterruptedException eParam) {
        }

        long delta = System.currentTimeMillis();
        StringBuilder str = new StringBuilder(2_000_000);
        for (int i = 0; i < 1_000_000; i++) {
            str.append(" test i: ")
               .append(i);
        }
        System.out.println("Delta : " + (System.currentTimeMillis() - delta));

//        long delta = System.currentTimeMillis();
//        String str = "";
//        for (int i = 0; i < 10_000; i++) {
//            str += " test i: " + i ;
//        }
//        System.out.println("Delta : " + (System.currentTimeMillis() - delta));

//        System.gc();
//
//        try {
//            Thread.sleep(2_000);
//        } catch (InterruptedException eParam) {
//        }
//
//         delta = System.currentTimeMillis();
//        for (int i = 0; i < 1_000_000; i++) {
//            method1("test " + counter + " i : " + i);
//        }
//        System.out.println("Delta : " + (System.currentTimeMillis() - delta));

        //        System.gc();
//
//        try {
//            Thread.sleep(2_000);
//        } catch (InterruptedException eParam) {
//        }
//        delta = System.currentTimeMillis();
//        for (int i = 0; i < 1_000_000; i++) {
//            method1(String.format("test %d i: %d",counter,i )) ;
//        }
//        System.out.println("Format Delta : " + (System.currentTimeMillis() - delta));

    }

    public static void method1(String sParam) {
    }

    public static void method2(Supplier<String> sParam) {

    }

}
