package com.training.performance.profileex;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MethodProfileTest {

    @Scheduled(fixedDelay = 1_000_000,initialDelay = 5_000)
    public void test1(){
        for (int i = 0; i < 2_000_000_000; i++) {
            method1();
        }
    }

    public void method1(){
        String str = "";
        for (int i = 0; i < 10; i++) {
            str += " xyz " + i;
        }
        method2();
    }

    private void method2() {
        method3();
    }

    private void method3() {
        try {
            Thread.sleep(3);
        } catch (InterruptedException eParam) {
        }
    }

}
