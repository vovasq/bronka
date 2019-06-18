package com.bronka.server.requests

data class BookRequest(val userId: Long, val restName: String, val bookingTime: String, val numOfPersons: Int) {
    override fun toString(): String {
        return "BookRequest(userId=$userId, restName='$restName', bookingTime='$bookingTime', numOfPersons=$numOfPersons)"
    }
}