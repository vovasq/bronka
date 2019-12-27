package com.bronka.server.entity

import javax.persistence.*

@Entity
@Table(name = "feedback")
data class Feedback(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        var id: Long?,

//        @ManyToOne(cascade = arrayOf(CascadeType.ALL))
//        @JoinTable(name = "feed_comment",
//                joinColumns = arrayOf(JoinColumn(name = "feedback_id", referencedColumnName = "id")) ,
//                inverseJoinColumns = arrayOf(JoinColumn(name = "comment_id", referencedColumnName = "id")))

//        @JoinColumn(name = "comment_id", referencedColumnName = "id")
//        var comment: Comment?,
        val text: String,
        val rate: Rate,
        val restaurant: String,
        val clientId: Long,
        val clientName: String
) {
    override fun toString(): String {
        return "Feedback(id=$id, rate=$rate, restaurant=$restaurant, client=$clientId)"
    }
}

enum class Rate {
    GREAT,
    OK,
    BAD,
    SHEET,
    EXCELLENT;

    fun toInt(): Int {
        return when(this){
            EXCELLENT -> 5
            GREAT -> 4
            OK -> 3
            BAD -> 2
            else -> 1
        }
    }
}