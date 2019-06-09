package com.bronka.server.controller

import com.bronka.server.entity.Restaurant
import com.bronka.server.entity.UserAccount
import com.bronka.server.repository.UserRepositoryJpa
import com.bronka.server.requests.LoginRequest
import com.bronka.server.service.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView


@RestController
open class BronkaController {

    @Qualifier("userRepositoryJpa")
    @Autowired
    private lateinit var userRepositoryJpa: UserRepositoryJpa

    @GetMapping("alive")
    fun alive(): String {
        return """
            |700, three high fives, look alive, look alive ('live)<br>
            |Niggas came up on this side, now they on the other side (word, word, word)<br>
            |Oh well, fuck 'em, dawg, we gon' see how hard they ride (huh, fuck 'em)<br>
            |I get racks to go outside and I split it with the guys (outside)<br>
            |We up on the other side, niggas actin' like we tied<br>
            |I've been gone since, like, July, niggas actin' like I died<br>
            |They won't be expectin' shit when Capo go to slide (hah)<br>
            |Cause I told them that we put that shit behind us but I— (hah)<br>""".trimMargin("|")
    }

    @GetMapping("resto")
//    @RequestParam(required = true)id: Long
    fun getRestsList(): List<String> {
        val list = ArrayList<String>()
        list.addAll(arrayOf("skkaka", "sadsadsa"))
        return list
    }

    @GetMapping("/")
    fun index(): ModelAndView {
        return ModelAndView("index.html")
    }

    @GetMapping("login")
    fun getAccountInfo(request: LoginRequest): UserAccount? {
        var result = userRepositoryJpa.findByEmail(request.email);
        if (result.isNotEmpty()) {
            if (result.get(0).password.equals(request.password))
                return result.get(0)
        }
        return null
    }

    @PostMapping("signup")
    fun getAccountInfo(account: UserAccount): UserAccount? {
        var result = userRepositoryJpa.findByEmail(account.email);
        if (result.isEmpty()) {
            return userRepositoryJpa.save(account)
        }
        return null
    }

}