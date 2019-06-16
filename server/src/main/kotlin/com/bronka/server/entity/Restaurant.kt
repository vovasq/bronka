package com.bronka.server.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
data class Restaurant(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long?,

        var name: String,
        var description: String,
        var location: String,
        var cousine: String,
        var rate: Int,
        var waiter: Long
//        var categories: List<Category>
) {
    override fun toString(): String {
        return "Restaurant(id=$id, name='$name', description='$description', location='$location', cousine='$cousine', rate=$rate)"
    }

}