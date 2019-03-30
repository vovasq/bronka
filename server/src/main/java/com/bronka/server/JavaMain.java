package com.bronka.server;

import org.apache.log4j.*;

public class JavaMain {

    private final static Logger LOG= Logger.getLogger(JavaMain.class);;

    public static String javaSendToKotlin(){
        return "This Hello is sent from JAVA!";
    }

    public static void main(String[] args) {
        LOG.info("muzafucccckaaaa");
        System.out.println(KotlinMainKt.KotlinHelloString);
        System.out.println(KotlinMainKt.getHelloStringFromJava());

    }
}
