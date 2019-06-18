package com.bronka.server.users

import com.bronka.server.entity.*
import com.bronka.server.repository.FeedbackRepositoryJpa
import com.bronka.server.repository.RestaurantRepositoryJpa
import com.bronka.server.repository.VisitRepositoryJpa
import com.bronka.server.utils.getCurrentTime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

class Client(val userAccount: UserAccount) {

    @Autowired
    private lateinit var restsRepo: RestaurantRepositoryJpa

    @Autowired
    private lateinit var feedbackRepo: FeedbackRepositoryJpa

    @Autowired
    private lateinit var visitsRepo: VisitRepositoryJpa

    fun createVisit(restName: String, bookingTime: String, numOfPersons: Int): Long? {
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

    fun getAllRestaurant(): List<Restaurant> {
        return restsRepo.findAll()
    }

    fun getAllVisitsInfo(): List<Visit> {
        return visitsRepo.findByClientName(userAccount.name)
    }

    fun getVisitInfo(id: Long): Visit {
        return visitsRepo.getOne(id)
    }

    private fun notClosedNotDeclined(visitInRep: Visit) = visitInRep.state != VisitState.DECLINED
            && visitInRep.state != VisitState.CLOSED

    private fun requestVisit(visit: Visit): Long? {
        var result = visitsRepo.save(visit)
        return result.id
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

    fun endVisit(visitId: Long, initialComment: Comment, rate: Rate,
                 restaurantName: String, client: Client): Feedback {
        var visit = visitsRepo.getOne(visitId)
        visit.state = VisitState.END
        visitsRepo.save(visit)
        return feedbackRepo.save(Feedback(null, initialComment, rate, restaurantName,
                client.userAccount.id!!, client.userAccount.name))
    }

}


