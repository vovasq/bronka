package com.bronka.server.service

import com.bronka.server.entity.*
import com.bronka.server.repository.AllRepositories
import com.bronka.server.repository.UserRepositoryJpa
import com.bronka.server.users.Client
import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ClientService {

    private val LOG = Logger.getLogger(UserAccount::class.java)

    @Autowired
    private lateinit var userRepo: UserRepositoryJpa

    @Autowired
    private lateinit var repos: AllRepositories

    fun createVisit(userId: Long, restName: String, bookingTime: String, numOfPersons: Int): Long? {
        return clientById(userId).createVisit(restName, bookingTime, numOfPersons)
    }

    fun getAllFeedbacksForRestaurantByName(restName: String) : List<Feedback>{
        return repos.feedbackRepo.findByRestaurant(restName)
    }

    fun cancelVisit(userId: Long, visitId: Long): Visit? {
        return clientById(userId).cancelVisit(visitId)
    }

    fun changeVisit(userId: Long, visit: Visit): Visit? {
        return clientById(userId).changeVisit(visit)
    }

    fun endVisit(userId: Long, visitId: Long, initialComment: String, rate: Rate): Feedback {
        val thisClient = clientById(userId)
        return thisClient.endVisit(
                visitId,
                initialComment,
                rate.toInt(),
                rate,
                repos.visitsRepo.findById(visitId).get().restaurant,
                thisClient)
    }


//    fun endVisit(userId: Long, visitId: Long, initialComment: Comment, rate: Rate): Feedback {
//        val thisClient = clientById(userId)
//        return thisClient.endVisit(
//                visitId,
//                initialComment,
//                rate.toInt(),
//                rate,
//                repos.visitsRepo.findById(visitId).get().restaurant,
//                thisClient)
//    }

    fun getAllRestaurant(userId: Long): List<Restaurant> {
        return clientById(userId).getAllRestaurant()
    }

    fun getAllVisitsInfo(userId: Long): List<Visit> {
        return clientById(userId).getAllVisitsInfo()
    }

    private fun clientById(userId: Long) = Client(userRepo.getOne(userId), repos)

}