package com.bronka.server.entity

import javax.persistence.*

@Entity
@Table(name = "feedback")
data class Feedback(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        val id: Long?,

        @ManyToOne(cascade = arrayOf(CascadeType.ALL))
//        @JoinTable(name = "feed_comment",
//                joinColumns = arrayOf(JoinColumn(name = "feedback_id", referencedColumnName = "id")) ,
//                inverseJoinColumns = arrayOf(JoinColumn(name = "comment_id", referencedColumnName = "id")))

        @JoinColumn(name = "comment_id", referencedColumnName = "id")
        var comment: Comment?,
        val rate: Rate,
        val restaurant: String,
        val clientId: Long,
        val clientName: String
) {
    override fun toString(): String {
        return "Feedback(id=$id, initialComment=$comment, rate=$rate, restaurant=$restaurant, client=$clientId)"
    }
}

enum class Rate {
    ONE_STARS,
    TWO_STARS,
    THREE_STARS,
    FOUR_STARS,
    FIVE_STARS
}