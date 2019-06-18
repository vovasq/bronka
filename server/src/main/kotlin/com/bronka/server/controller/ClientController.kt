package com.bronka.server.controller

import com.bronka.server.entity.Restaurant
import com.bronka.server.repository.RestaurantRepositoryJpa
import com.bronka.server.requests.BookRequest
import com.bronka.server.service.ClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*


@Controller
class ClientController {

    @Autowired
    private lateinit var restaurantRepo: RestaurantRepositoryJpa

    @Autowired
    private lateinit var clientService: ClientService


    @GetMapping("/resto")
    @ResponseBody
    fun getRestsList(): List<Restaurant> {
        return restaurantRepo.findAll()
    }

    @GetMapping("/client")
    fun clientPage():String{
        return "client"
    }

    @PostMapping("/book")
    @ResponseBody
    fun bookRestaurant(request: BookRequest): Long?{
        println(request)
        return null
//        return clientService.createVisit(request.userId,
//                request.restName,request.bookingTime,request.numOfPersons)
    }
}