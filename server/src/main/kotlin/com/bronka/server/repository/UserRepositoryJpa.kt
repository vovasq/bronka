package com.bronka.server.repository

import com.bronka.server.entity.UserAccount
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.stereotype.Repository

interface UserRepositoryJpa : JpaRepository<UserAccount, Long> {
    fun findByName(name: String): List<UserAccount>
    fun findByEmail(email: String): List<UserAccount>

}