package com.bronka.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class BronkaApplication
//    @Autowired
//    private lateinit var repository: BookRepository

//    @Autowired
//    private lateinit var userRepo: UserRepositoryJpa


//    @PostConstruct
//    fun run() {
//
//        repository.save(Book("Java"))
//        repository.save(Book("Node"))
//        repository.save(Book("Python"))
//
//        println("\nfindAll()")
//        repository.findAll().forEach { x -> println(x) }
//
//        println("\nfindById(1L)")
//        repository.findById(1L).ifPresent { x -> println(x) }
//
//        println("\nfindByName('Node')")
//        repository.findByName("Node").forEach { x -> println(x) }
//
//    }


fun main(args: Array<String>) {
    runApplication<BronkaApplication>(*args)
}