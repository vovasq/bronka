package com.bronka.server.users

import com.bronka.server.entity.*
import com.bronka.server.repository.AllRepositories
import com.bronka.server.repository.FeedbackRepositoryJpa
import com.bronka.server.repository.RestaurantRepositoryJpa
import com.bronka.server.repository.VisitRepositoryJpa
import org.springframework.beans.factory.annotation.Autowired

class Waiter(val userAccount: UserAccount, var restaurantName: String?, val repos:AllRepositories) {

    fun registerNewRestaurant(restaurant: Restaurant) {
        TODO()
    }

    fun declineVisit(id: Long, comment: Comment) {
        updateVisitState(id, VisitState.DECLINED)
    }

    fun checkVisitsWithTime(time: String) {
        TODO()
    }

    fun getNewVisits(): List<Visit> {
        return repos.visitsRepo.findByRestaurant(restaurantName!!)
    }

    private fun updateVisitState(id: Long, state: VisitState) {
        var visit = repos.visitsRepo.getOne(id)
        if (visit != null) {
            visit.state = state
            repos.visitsRepo.save(visit)
        }
    }

    fun approveVisit(id: Long) {
        updateVisitState(id, VisitState.APPROVED)
    }

    fun endMissedVisit(id: Long) {
        updateVisitState(id, VisitState.MISSED)
    }

    fun endVisitAndCreateReport(id: Long) {
        endVisit(id)
    }

    fun createComment(feedbackId: Long, comment: Comment) {

    }

    private fun endVisit(id: Long) {
        updateVisitState(id, VisitState.END)
    }


    fun purposeNewVisit() {
        TODO()
    }


}