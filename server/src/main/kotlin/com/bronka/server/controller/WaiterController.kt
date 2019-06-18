package com.bronka.server.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping


@Controller
class WaiterController {

    @GetMapping("/waiter")
    fun waiterPage():String{
        return "waiter"
    }
}