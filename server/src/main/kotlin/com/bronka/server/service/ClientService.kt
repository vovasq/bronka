package com.bronka.server.service

import com.bronka.server.entity.*
import com.bronka.server.repository.UserRepositoryJpa
import com.bronka.server.users.Client
import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired

class ClientService {

    private val LOG = Logger.getLogger(UserAccount::class.java)

    @Autowired
    private lateinit var userRepo: UserRepositoryJpa

    fun createVisit(userId: Long, restName: String, bookingTime: String, numOfPersons: Int): Long? {
        return clientById(userId).createVisit(restName, bookingTime, numOfPersons)
    }

    fun cancelVisit(userId: Long, visit: Visit): Visit? {
        return clientById(userId).cancelVisit(visit)
    }

    fun changeVisit(userId: Long, visit: Visit): Visit? {
        return clientById(userId).changeVisit(visit)
    }

    fun endVisit(userId: Long, visitId: Long, initialComment: Comment, rate: Rate,
                 restaurantName: String, client: Client): Feedback {
        return clientById(userId).endVisit(visitId, initialComment, rate, restaurantName, client)
    }

    fun getAllRestaurant(userId: Long):List<Restaurant>{
        return clientById(userId).getAllRestaurant()
    }

    private fun clientById(userId: Long) = Client(userRepo.getOne(userId))


}