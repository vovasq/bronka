package com.bronka.server.repository

import com.bronka.server.entity.UserAccount
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepositoryJpa : JpaRepository<UserAccount, Long> {
    fun findByName(name: String): List<UserAccount>
    fun findByEmail(email: String): List<UserAccount>

}