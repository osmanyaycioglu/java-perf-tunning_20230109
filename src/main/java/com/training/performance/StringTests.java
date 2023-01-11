package com.training.performance;

public class StringTests {
    public static void main(String[] args) {
        String strTest = "deneme " + args ;
        strTest += " test2";

        String s = new String("test3");

        String concat = strTest.concat(" concat function");

        String dogruKullanimStr = "deneme " + args  + " test2" + " concat function";

        System.out.println(concat);

    }
}
