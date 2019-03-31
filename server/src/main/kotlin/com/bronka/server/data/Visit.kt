package com.bronka.server.data

data class Visit(val id: String, val creatingTime: Long, var state: VisitState,
                 var bookingTime: Long, var numOfPersons: Int,
                 val restaurant: String,
                 val clientName: String, val clientId: String)

enum class VisitState {
    NEW,
    IN_PROCCESS,
    APPROVED,
    END,
    CLOSED;
}