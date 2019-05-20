package com.bronka.server.data

import org.apache.log4j.Logger

open class UserAccount(val id: String,
                        val login: String,
                       val password: String,
                       var name: String,
                       var phone: String,
                       var email: String) {

    init {
        val LOG = Logger.getLogger(UserAccount::class.java)
        LOG.info("Created user with id = $id, login = $login, name = $name")
    }
}