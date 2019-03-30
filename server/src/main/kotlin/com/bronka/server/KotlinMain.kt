package com.bronka.server;

const val KotlinHelloString : String = "This Hello is sent from Kotlin!"

fun getHelloStringFromJava() : String {
    return JavaMain.javaSendToKotlin()!!;
}
