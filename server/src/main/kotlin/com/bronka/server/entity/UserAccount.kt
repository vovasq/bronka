package com.bronka.server.entity

import javax.persistence.*

@Entity
data class UserAccount(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long?,

        val role: String,
        var name: String,
        var login: String,
        var password: String,
        var phone: String,
        var email: String
) {
    override fun toString(): String {
        return "UserAccount(id=$id, role='$role', name='$name', login='$login', password='$password', name='$name', phone='$phone', email='$email')"
    }
}

