package com.bronka.server.service

import com.bronka.server.entity.UserAccount
import com.bronka.server.repository.UserRepositoryJpa
import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired

class ClientService{

    private val LOG = Logger.getLogger(UserAccount::class.java)

    @Autowired
    private lateinit var userRepo: UserRepositoryJpa





}