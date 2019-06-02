package com.bronka.server.users

import com.bronka.server.entity.*
import com.bronka.server.repository.RestaurantRepository
import com.bronka.server.repository.VisitRepository
import com.bronka.server.utils.getCurrentTime
import org.springframework.beans.factory.annotation.Autowired

class Client(id: String, login: String, password: String, name: String, phone: String, email: String) :
        UserAccount(id, login, password, name, phone, email) {

    @Autowired
    private lateinit var restsRepo: RestaurantRepository
    @Autowired
    private lateinit var visitsRepo: VisitRepository

    fun chooseRestAndRequest(restId: String, restName: String, bookingTime: String, numOfPersons: Int) {
        requestVisit(Visit(
                this.id + restId,
                getCurrentTime(),
                VisitState.NEW,
                bookingTime,
                numOfPersons,
                restName,
                this.name,
                this.id)
        )
    }

    private fun requestVisit(visit: Visit) {
        visitsRepo.createWithId(visit)
    }

    fun getVisitInfo(id: String): Visit {
        return visitsRepo.selectById(id)
    }

    fun cancelVisit(visit: Visit) {
        visitsRepo.updateVisitState(visit.id, VisitState.CLOSED)
    }

    fun changeVisit(visit: Visit) {
        visitsRepo.updateById(visit.id, visit)
    }

    fun getRestsByCategories(categories: List<Category>): List<Restaurant> {
        TODO()
    }

    fun leaveComment() {
        TODO()
    }

    fun endVisit(initialComment: Comment, rate: Rate,
                 restaurant: Restaurant, client: Client) {
        TODO()
    }


}


