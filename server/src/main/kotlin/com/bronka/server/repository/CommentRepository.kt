package com.bronka.server.repository

import com.bronka.server.entity.Comment
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.stereotype.Repository

interface CommentRepository : JpaRepository<Comment, Long> {

    fun findByAuthorId(authorId: Long): List<Comment>
    fun findByAuthorName(authorName: String): List<Comment>

}