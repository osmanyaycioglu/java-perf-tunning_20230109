package com.training.performance;

import java.util.List;

public class Test3 {

    private String testStr = "test";


    public static void main(String[] args) {
        Test3 test3 = new Test3();
        test3.method1("osman", 5);
    } // Str1Obj refcount(0) + test3Obj refcount(0)

    public String method1(String str,
                          Integer intVal) {
        String strl = str + " " + intVal;  // Str1Obj refcount(1)
        String strl2 = strl; // Str1Obj refcount(2)
        testStr = strl; // Str1Obj refcount(3)
        int count = intVal + 10;
        Person person1 = new Person("osman",
                                    "yay",
                                    200,
                                    100); // person1Obj  refcount(1)
        Person person2 = new Person("ayşe",
                                    "alaz",
                                    165,
                                    55); // person2Obj  refcount(1)
        Person person3 = person1; // person1Obj  refcount(2)
        System.out.println(strl + " " + person3);
        String sMethod2 = method2();
        return person1 + " " + person2;
    } // Str1Obj refcount(1) + // person1Obj  refcount(0) + // person2Obj  refcount(0)

    public String method2() {
        Person person1 = new Person("osman",
                                    "yay",
                                    200,
                                    100);
        return person1 + " deneme";
    }


}
