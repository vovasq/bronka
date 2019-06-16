package com.bronka.server.users

import com.bronka.server.entity.*
import com.bronka.server.repository.FeedbackRepositoryJpa
import com.bronka.server.repository.RestaurantRepositoryJpa
import com.bronka.server.repository.VisitRepositoryJpa
import org.springframework.beans.factory.annotation.Autowired

class Waiter(val userAccount: UserAccount, var restaurantName: String?) {

    @Autowired
    private lateinit var restsRepo: RestaurantRepositoryJpa
    @Autowired
    private lateinit var visitsRepo: VisitRepositoryJpa
    @Autowired
    private lateinit var feedbackRepo: FeedbackRepositoryJpa

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
        return visitsRepo.findByRestaurant(restaurantName!!)
    }

    private fun updateVisitState(id: Long, state: VisitState) {
        var visit = visitsRepo.getOne(id)
        if (visit != null) {
            visit.state = state
            visitsRepo.save(visit)
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