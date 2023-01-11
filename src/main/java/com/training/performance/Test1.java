package com.training.performance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

public class Test1 {

    public static Logger logger = LoggerFactory.getLogger(Test1.class);

    public static int count = 0;

    public static void main(String[] args) {

        for (int i = 0; i < 2000; i++) {
            doSomethingLazy(() -> "arg " + args + " " + count);
            doSomethingLazyDynamic(intVal -> "arg " + args + " " + count + " i " + intVal,
                                   i);

            logger.debug("arg " + args + " " + count);

            if (logger.isTraceEnabled()) {
                logger.trace("arg " + args + " " + count + " i : " + i);
            }
            count++;
            logger.debug("arg {} count {}",
                         args,
                         count);
            if (logger.isDebugEnabled()) {
                logger.debug("arg " + args + " " + count);
            }

            if (count > 1000) {
                doSomething("arg " + args + " " + count);
            }
        }
    }

    public static void doSomething(String str) {
        System.out.println(str);
    }

    public static void doSomethingLazy(Supplier<String> str) {
        if (count > 1000) {
            System.out.println(str.get());
        }
    }

    public static void doSomethingLazyDynamic(IDoSomething str,
                                              int index) {
        if (count > 1000) {
            System.out.println(str.createString(index));
        }
    }

}
