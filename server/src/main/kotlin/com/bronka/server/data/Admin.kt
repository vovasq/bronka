package com.bronka.server.data

class Admin(id: String, login: String, password: String, name: String, phone: String, email: String) :
        UserAccount(id, login, password, name, phone, email)