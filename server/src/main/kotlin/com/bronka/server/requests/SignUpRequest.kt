package com.bronka.server.requests

data class SignUpRequest(
        val role: String,
        var name: String,
        var login: String,
        var password: String,
        var phone: String,
        var email: String,
        var restaurantName: String?
)