package com.bronka.server.entity

data class Visit(val id: String, val creatingTime: String, var state: VisitState,
                 var bookingTime: String?, var numOfPersons: Int,
                 val restaurant: String,
                 val clientName: String, val clientId: String)

enum class VisitState {
    NEW,
    IN_PROCESS,
    DECLINED,
    APPROVED,
    END,
    CLOSED;
}