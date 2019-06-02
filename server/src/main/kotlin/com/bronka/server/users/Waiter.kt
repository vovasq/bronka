package com.bronka.server.users

import com.bronka.server.entity.Comment
import com.bronka.server.entity.UserAccount
import com.bronka.server.entity.VisitState
import com.bronka.server.repository.VisitRepository
import org.springframework.beans.factory.annotation.Autowired

class Waiter(id: String, login: String, password: String, name: String, phone: String, email: String) :
        UserAccount(id, login, password, name, phone, email) {

    @Autowired
    private lateinit var visitRepository: VisitRepository

    fun declineVisit(id:String, comment: Comment) {
        visitRepository.updateVisitState(id, VisitState.DECLINED)
    }

    fun checkVisitsWithTime(time:String){
        TODO()
    }

    fun approveVisit(id: String){
        visitRepository.updateVisitState(id, VisitState.APPROVED)
    }

    fun purposeNewVisit(){

    }

    fun getNewVisits(){}

}