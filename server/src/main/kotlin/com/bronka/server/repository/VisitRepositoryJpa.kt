package com.bronka.server.repository

import com.bronka.server.entity.Visit
import org.springframework.data.jpa.repository.JpaRepository

interface VisitRepositoryJpa :JpaRepository<Visit, Long> {
    fun findByClientId(clientId: Long): List<Visit>
    fun findByClientName(clientName: String): List<Visit>
    fun findByRestaurant(restaurant: String): List<Visit>

}