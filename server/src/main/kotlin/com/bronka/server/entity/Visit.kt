package com.bronka.server.entity

import javax.persistence.*

@Entity
@Table(name = "visits")
data class Visit(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long?,
        val creatingTime: String,
        var state: VisitState,
        var bookingTime: String?,
        var numOfPersons: Int,
        val restaurant: String,
        val clientName: String,
        val clientId: Long) {
    override fun toString(): String {
        return "Visit(id='$id', creatingTime='$creatingTime', state=$state, bookingTime=$bookingTime, numOfPersons=$numOfPersons, restaurant='$restaurant', clientName='$clientName', clientId='$clientId')"
    }
}

enum class VisitState {
    NEW,
    IN_PROCESS,
    DECLINED,
    APPROVED,
    MISSED,
    END,
    CLOSED;
}