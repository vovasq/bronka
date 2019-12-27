package com.bronka.server.controller

import com.bronka.server.entity.*
import com.bronka.server.repository.RestaurantRepositoryJpa
import com.bronka.server.requests.BookRequest
import com.bronka.server.requests.FeedbackRequest
import com.bronka.server.service.ClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import java.time.LocalDateTime.now


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

    @GetMapping("/resto/feedback")
    @ResponseBody
    fun getRestFeedback(@RequestParam(required = true) restName: String): List<Feedback> {
        return clientService.getAllFeedbacksForRestaurantByName(restName)
    }


    @GetMapping("/client")
    fun clientPage(): String {
        return "client"
    }

    @GetMapping("/cabinet")
    fun clientCabinetPage(): String {
        return "cabinet"
    }

    @GetMapping("/myvisits")
    @ResponseBody
    fun getMyVisits(@RequestParam(required = true) id: Long): List<Visit> {
        return clientService.getAllVisitsInfo(id)
    }

    @GetMapping("/cancel")
    @ResponseBody
    fun cancelVisit(@RequestParam(required = true) userId: Long, @RequestParam(required = true) visitId: Long): String {
        println("cancel with params $userId, $visitId")
        println(clientService.cancelVisit(userId, visitId))
        return "OK"
    }

    @PostMapping("/book")
    @ResponseBody
    fun bookRestaurant(request: BookRequest): Long? {
        return clientService.createVisit(request.userId,
                request.restName, request.bookingTime, request.numOfPersons)
    }

    @PostMapping("/close")
    @ResponseBody
    fun closeVisit(request: FeedbackRequest): Feedback {
        println(request)
/*
        return clientService.endVisit(
                request.userId,
                request.visitId,
                Comment(null, now().toString(),
                        request.text,
                        request.userId,
                        null,
                        null),
                Rate.valueOf(request.rate))
*/

        return clientService.endVisit(
                request.userId,
                request.visitId,
                request.text, Rate.valueOf(request.rate))

    }

}