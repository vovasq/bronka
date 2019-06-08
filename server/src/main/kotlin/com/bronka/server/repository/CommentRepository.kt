package com.bronka.server.repository

import com.bronka.server.entity.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, Long> {

    fun findByAuthorId(authorId: Long): List<Comment>
    fun findByAuthorName(authorName: String): List<Comment>

}