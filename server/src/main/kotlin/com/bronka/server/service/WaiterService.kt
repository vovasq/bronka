package com.bronka.server.service

import com.bronka.server.entity.Comment
import com.bronka.server.entity.Restaurant
import com.bronka.server.entity.Visit
import com.bronka.server.entity.VisitState
import com.bronka.server.repository.AllRepositories
import com.bronka.server.repository.UserRepositoryJpa
import com.bronka.server.users.Waiter
import com.bronka.server.utils.getCurrentTime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class WaiterService {

    @Autowired
    private lateinit var repos: AllRepositories

    @Autowired
    private lateinit var userRepo: UserRepositoryJpa

    fun getVisits(id: Long, restName: String): List<Visit> {
        return getWaiterById(id, restName).getNewVisits()
    }

    fun getMyRestaurantName(id: Long): Restaurant {
        return repos.restsRepo.findByWaiter(id)
    }

    fun approveVisit(waiterId: Long, restName: String,visitId:Long) {
        getWaiterById(waiterId,restName).approveVisit(visitId)
    }

    fun declineVisit(waiterId: Long, restaurantName: String, visitId: Long, comment:String) {
        getWaiterById(waiterId,restaurantName).declineVisit(visitId, Comment(null,
                getCurrentTime(),comment,waiterId,"name", null))
    }


    private fun getWaiterById(id: Long, restName: String) =
            Waiter(userRepo.getOne(id),
                    restName,
                    repos)



}