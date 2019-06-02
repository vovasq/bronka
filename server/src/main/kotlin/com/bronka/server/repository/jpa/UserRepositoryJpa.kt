package com.bronka.server.repository.jpa

import com.bronka.server.entity.UserAccount
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepositoryJpa :JpaRepository<UserAccount, Long> {

}