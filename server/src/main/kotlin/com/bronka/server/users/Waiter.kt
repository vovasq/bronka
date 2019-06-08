package com.bronka.server.users

import com.bronka.server.entity.Comment
import com.bronka.server.entity.UserAccount
import com.bronka.server.repository.VisitRepositoryJpa
import org.springframework.beans.factory.annotation.Autowired

class Waiter(userAccount: UserAccount) {

    @Autowired
    private lateinit var visitRepository: VisitRepositoryJpa

    fun declineVisit(id: String, comment: Comment) {
        TODO()
//        visitRepository.updateVisitState(id, VisitState.DECLINED)
    }

    fun checkVisitsWithTime(time: String) {
        TODO()
    }

    fun approveVisit(id: String) {
        TODO()
//        visitRepository.updateVisitState(id, VisitState.APPROVED)
    }

    fun purposeNewVisit() {
        TODO()

    }

    fun getNewVisits() {
        TODO()
    }

}