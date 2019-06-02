package com.bronka.server.entity

open class UserAccount(val id: String,
                       val login: String,
                       val password: String,
                       var name: String,
                       var phone: String,
                       var email: String)
//                       ,
//                       val role: String) {
//
//}