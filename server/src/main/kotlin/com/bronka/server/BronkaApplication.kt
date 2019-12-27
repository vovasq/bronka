package com.bronka.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class BronkaApplication

fun main(args: Array<String>) {
    runApplication<BronkaApplication>(*args)
}