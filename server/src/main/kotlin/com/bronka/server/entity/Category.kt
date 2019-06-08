package com.bronka.server.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Category(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long?,

        val name: String,
        val value: String
) {
    override fun toString(): String {
        return "Category(id=$id, name='$name', value='$value')"
    }
}