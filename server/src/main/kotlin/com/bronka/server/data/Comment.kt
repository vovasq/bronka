package com.bronka.server.data

data class Comment(val id: String, val creationTime: Long,
                   val text: String, val authorId: String,
                   val authorName: String)