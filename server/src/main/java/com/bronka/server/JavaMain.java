package com.bronka.server;


public class JavaMain {

    public static String javaSendToKotlin(){
        return "This Hello is sent from JAVA!";
    }

    public static void main(String[] args) {
        System.out.println(KotlinMainKt.KotlinHelloString);
        System.out.println(KotlinMainKt.getHelloStringFromJava());
    }
}
