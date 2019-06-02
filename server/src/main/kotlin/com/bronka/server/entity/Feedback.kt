package com.bronka.server.entity

import com.bronka.server.users.Client

data class Feedback(val initialComment: Comment, val rate: Rate,
                    val restaurant: Restaurant, val client: Client)

enum class Rate{
    ONE_STARS,
    TWO_STARS,
    THREE_STARS,
    FOUR_STARS,
    FIVE_STARS
}