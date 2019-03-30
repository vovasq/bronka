package com.bronka.server

import org.apache.log4j.*

const val KotlinHelloString : String = "This Hello is sent from Kotlin!"

fun getHelloStringFromJava() : String {
    val LOG = Logger.getLogger(JavaMain::class.java)
    LOG.info("In Kotlin it also works")
    return JavaMain.javaSendToKotlin()!!
}
