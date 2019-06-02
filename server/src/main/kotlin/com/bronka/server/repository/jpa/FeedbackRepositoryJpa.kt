package com.bronka.server.repository.jpa

import com.bronka.server.entity.Feedback
import org.springframework.data.jpa.repository.JpaRepository

interface FeedbackRepositoryJpa : JpaRepository<Feedback, Long> {
}