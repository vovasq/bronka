package com.bronka.server.users

import com.bronka.server.entity.*
import com.bronka.server.repository.AllRepositories
import com.bronka.server.utils.getCurrentTime

class Client(val userAccount: UserAccount, val repos: AllRepositories) {


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

    fun cancelVisit(visitId: Long): Visit? {
        val visitInRep = repos.visitsRepo.getOne(visitId)
        if (notClosedNotDeclined(visitInRep)) {
            visitInRep.state = VisitState.DECLINED
        } else {
            return null
        }
        return repos.visitsRepo.save(visitInRep)
    }

    fun changeVisit(visit: Visit): Visit? {
        val visitInRep = repos.visitsRepo.getOne(visit.id)
        if (notClosedNotDeclined(visitInRep) && visitInRep != null) {
            visitInRep.bookingTime = visit.bookingTime
            visitInRep.numOfPersons = visit.numOfPersons
            return repos.visitsRepo.save(visitInRep)
        } else {
            return null
        }
    }

    fun getAllRestaurant(): List<Restaurant> {
        return repos.restsRepo.findAll()
    }

    fun getAllVisitsInfo(): List<Visit> {
        return repos.visitsRepo.findByClientName(userAccount.name)
    }

    fun getVisitInfo(id: Long): Visit {
        return repos.visitsRepo.getOne(id)
    }

    private fun notClosedNotDeclined(visitInRep: Visit) = visitInRep.state != VisitState.DECLINED
            && visitInRep.state != VisitState.CLOSED

    private fun requestVisit(visit: Visit): Long? {
        val result = repos.visitsRepo.save(visit)
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

    private fun updateRestaurantRateAfterVisit(restName: String, rate: Rate) =
            repos.restsRepo.save(repos.restsRepo.findByName(restName)[0])

    fun endVisit(visitId: Long, initialComment: Comment, rate: Rate,
                 restName: String, client: Client): Feedback {
        val visit = repos.visitsRepo.getOne(visitId)
        visit.state = VisitState.END
        repos.visitsRepo.save(visit)
        repos.commentRepository.save(initialComment)
        updateRestaurantRateAfterVisit(restName, rate)
        val feedback = repos.feedbackRepo.save(Feedback(null, initialComment, rate, restName,
                client.userAccount.id!!, client.userAccount.name))
        return feedback
    }

}


