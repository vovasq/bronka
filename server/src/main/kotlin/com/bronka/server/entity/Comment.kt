package com.bronka.server.entity

data class Comment(val id: String, val creationTime: Long,
                   val text: String, val authorId: String,
                   val authorName: String)