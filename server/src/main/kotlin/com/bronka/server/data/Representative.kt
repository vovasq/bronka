package com.bronka.server.data

class Representative(id: String, login: String, password: String, name: String, phone: String, email: String) :
        UserAccount(id, login, password, name, phone, email) {

    fun declineVisit() {}

    fun purposeNewVisit(){}

    fun getNewVisits(){}

}