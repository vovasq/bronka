package com.bronka.server.users

import com.bronka.server.entity.*
import com.bronka.server.repository.FeedbackRepositoryJpa
import com.bronka.server.repository.RestaurantRepositoryJpa
import com.bronka.server.repository.VisitRepositoryJpa
import com.bronka.server.utils.getCurrentTime
import org.springframework.beans.factory.annotation.Autowired

class Client(val userAccount: UserAccount) {

    @Autowired
    private lateinit var restsRepo: RestaurantRepositoryJpa
    @Autowired
    private lateinit var visitsRepo: VisitRepositoryJpa
    @Autowired
    private lateinit var feedbackRepo: FeedbackRepositoryJpa

    fun getAllRestaurant():List<Restaurant>{
        return restsRepo.findAll()
    }

    fun createVisit(restId: String, restName: String, bookingTime: String, numOfPersons: Int): Long? {
        return requestVisit(Visit(
                null,
                getCurrentTime(),
                VisitState.NEW,
                bookingTime,
                numOfPersons,
                restName,
                userAccount.name,
                userAccount.id!!)
        )
    }

    private fun requestVisit(visit: Visit): Long? {
        var result = visitsRepo.save(visit)
        return result.id
    }

    fun getVisitInfo(id: Long): Visit {
        return visitsRepo.getOne(id)
    }

    private fun notClosedNotDeclined(visitInRep: Visit) = visitInRep.state != VisitState.DECLINED
            && visitInRep.state != VisitState.CLOSED

    fun cancelVisit(visit: Visit): Visit? {
        var visitInRep = visitsRepo.getOne(visit.id)
        if (notClosedNotDeclined(visitInRep)) {
            visitInRep.state = VisitState.DECLINED
        } else {
            return null
        }
        return visitsRepo.save(visitInRep)
    }

    fun changeVisit(visit: Visit): Visit? {
        var visitInRep = visitsRepo.getOne(visit.id)
        if (notClosedNotDeclined(visitInRep) && visitInRep != null) {
            visitInRep.bookingTime = visit.bookingTime
            visitInRep.numOfPersons = visit.numOfPersons
            return visitsRepo.save(visitInRep)
        } else {
            return null
        }
    }

    fun getRestsByCategories(categories: List<Category>): List<Restaurant> {
        TODO()
    }

    fun leaveComment(comment: Comment) {
        TODO()
    }

    fun leaveFeedBack(feedback: Feedback) {
        TODO()
    }

    fun endVisit(visit: Visit, initialComment: Comment, rate: Rate,
                 restaurant: Restaurant, client: Client): Feedback {
        return feedbackRepo.save(Feedback(null, initialComment, rate, restaurant.name,
                client.userAccount.id!!, client.userAccount.name))
    }

}


