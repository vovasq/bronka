package com.bronka.server.controller

import com.bronka.server.entity.Restaurant
import com.bronka.server.entity.Visit
import com.bronka.server.service.WaiterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody


@Controller
class WaiterController {

    @Autowired
    private lateinit var waiterService: WaiterService

    @GetMapping("/waiter")
    fun waiterPage():String{
        return "waiter"
    }

    @GetMapping("/getrest")
    @ResponseBody
    fun getMyInfo(@RequestParam(required = true) id:Long):Restaurant{
        return waiterService.getMyRestaurantName(id)
    }


    @GetMapping("/visits")
    @ResponseBody
    fun getRestoVisits(@RequestParam(required = true) id:Long, @RequestParam(required = true) restaurantName: String):List<Visit>{
        return waiterService.getVisits(id,restaurantName)
    }

    @GetMapping("/approve")
    @ResponseBody
    fun approveVisit(@RequestParam(required = true) waiterId:Long, @RequestParam(required = true) restaurantName: String, visitId:Long):String{
        waiterService.approveVisit(waiterId,restaurantName,visitId)
        return "Ok"
    }

    @GetMapping("/decline")
    @ResponseBody
    fun declineVisit(@RequestParam(required = true) waiterId:Long, @RequestParam(required = true) restaurantName: String, visitId:Long, comment:String):String{
        waiterService.declineVisit(waiterId,restaurantName,visitId, comment)
        return "Ok"
    }


}