package com.bronka.server.repository

import com.bronka.server.entity.Feedback
import org.springframework.data.jpa.repository.JpaRepository

interface FeedbackRepositoryJpa : JpaRepository<Feedback, Long> {
    fun findByClientId(clientId: Long): List<Feedback>
    fun findByClientName(name: String): List<Feedback>
}