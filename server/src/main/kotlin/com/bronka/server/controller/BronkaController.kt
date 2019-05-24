package com.bronka.server.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class BronkaController {
    @GetMapping("alive")
    fun alive():String{
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

}