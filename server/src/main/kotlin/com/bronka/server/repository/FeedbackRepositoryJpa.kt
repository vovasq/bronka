package com.bronka.server.repository

import com.bronka.server.entity.Feedback
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.stereotype.Repository

interface FeedbackRepositoryJpa : JpaRepository<Feedback, Long> {
    fun findByClientId(clientId: Long): List<Feedback>
    fun findByClientName(name: String): List<Feedback>
    fun findByRestaurant(name: String): List<Feedback>
}