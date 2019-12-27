package com.bronka.server.entity

import javax.persistence.*

@Entity
@Table(name = "comment")
data class Comment(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        var id: Long?,

        val creationTime: String,
        val text: String,
        val authorId: Long?,
        val authorName: String?

//        @OneToOne(mappedBy = "comment",cascade = arrayOf(CascadeType.ALL)) //, fetch = FetchType.EAGER)
//        @ManyToOne//(cascade = arrayOf(CascadeType.ALL)) //, fetch = FetchType.EAGER)
//        var feedback: Feedback?
) {
    override fun toString(): String {
        return "Comment(id=$id, creationTime=$creationTime, text='$text', authorId='$authorId', authorName='$authorName')"
    }
}